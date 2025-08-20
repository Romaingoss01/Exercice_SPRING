package com.example.exercice3.service;

import com.example.exercice3.entity.Produit;
import com.example.exercice3.repository.ProduitRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> listerProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduit(int id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
    }

}
