package org.example.environement.service;

import org.example.environement.dto.travellogs.TravellogDtoReceive;
import org.example.environement.dto.travellogs.TravellogDtoResponse;
import org.example.environement.dto.travellogs.TravellogDtoStat;
import org.example.environement.entity.Observation;
import org.example.environement.entity.Travellog;
import org.example.environement.exception.NotFoundException;
import org.example.environement.repository.ObservationRepository;
import org.example.environement.repository.TravellogRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TravellogService {

    private final TravellogRepository travellogRepository;
    private final ObservationRepository observationRepository;

    public TravellogService(TravellogRepository travellogRepository,  ObservationRepository observationRepository) {
        this.travellogRepository = travellogRepository;
        this.observationRepository = observationRepository;
    }

    public TravellogDtoStat getStat(Long observationId) {
        List<Travellog> travellogs = travellogRepository.findTravellogByObservation_Id(observationId);

        double totalDistance = travellogs.stream().mapToDouble(Travellog::getDistanceKm).sum();
        double totalCo2 = travellogs.stream().mapToDouble(Travellog::getEstimatedCo2Kg).sum();

        Map<String, Double> byMode = travellogs.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getMode().name(),
                        Collectors.summingDouble(Travellog::getEstimatedCo2Kg)));
        return TravellogDtoStat.builder()
                .totalDistanceKm(totalDistance)
                .totalEmissionsKg(totalCo2)
                .byMode(byMode)
                .build();
    }

    public List<TravellogDtoResponse> get(int nb) {
        Iterable<Travellog> travellogs = travellogRepository.findAll(PageRequest.of(0, nb)).getContent();
        return StreamSupport.stream(travellogs.spliterator(), false)
                .map(Travellog::entityToDto)
                .collect(Collectors.toList());
    }




    public Map<String, TravellogDtoStat> getStatForUserLastMonth(String name){
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        List<Travellog> travellogs = travellogRepository.findTravellogByUserForLastMonth(name, oneMonthAgo);

        Map<Long, TravellogDtoStat> statsByObservation = new HashMap<>();

        for (Travellog t : travellogs) {
            long observationId = t.getObservation().getId();
            statsByObservation.putIfAbsent(observationId, new TravellogDtoStat());
            TravellogDtoStat stat = statsByObservation.get(observationId);
            stat.addTotalDistanceKm(t.getDistanceKm());
            stat.addTotalEmissionsKg(t.getEstimatedCo2Kg());
            stat.addMode(t.getMode().name(), t.getDistanceKm());
        }

        Map<String, TravellogDtoStat> result = new HashMap<>();
        statsByObservation.forEach((k,v) -> result.put(k.toString(), v));

        return result;
    }

    public TravellogDtoResponse create(TravellogDtoReceive travellogDtoReceive, long observationId) {
        Travellog travellog = travellogDtoReceive.dtoToEntity();

        Observation observation = observationRepository.findById(observationId)
                .orElseThrow();
        travellog.setObservation(observation);
        travellog.calculateCO2();

        Travellog saved = travellogRepository.save(travellog);
        return saved.entityToDto();
    }


}
