package com.example.exercice3.service;

import com.example.exercice3.entity.LignePanier;
import com.example.exercice3.entity.Panier;
import com.example.exercice3.entity.Produit;
import com.example.exercice3.repository.LignePanierRepository;
import com.example.exercice3.repository.PanierRepository;
import com.example.exercice3.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class LignePanierService {

    private final LignePanierRepository lignePanierRepository;
    private final PanierRepository panierRepository;
    private final ProduitRepository produitRepository;

    public LignePanierService(LignePanierRepository lignePanierRepository, PanierRepository panierRepository, ProduitRepository produitRepository) {
        this.lignePanierRepository = lignePanierRepository;
        this.panierRepository = panierRepository;
        this.produitRepository = produitRepository;
    }

    public LignePanier ajouterProduit(int panierId, int produitId, int quantite) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier introuvable"));
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        LignePanier ligneExistante = panier.getLignes().stream()
                .filter(lp -> lp.getProduit().getId() == produitId)
                .findFirst()
                .orElse(null);

        if (ligneExistante != null) {
            ligneExistante.setQuantite(ligneExistante.getQuantite() + quantite);
            return lignePanierRepository.save(ligneExistante);
        }

        LignePanier nouvelleLigne = new LignePanier();
        nouvelleLigne.setPanier(panier);
        nouvelleLigne.setProduit(produit);
        nouvelleLigne.setQuantite(quantite);

        panier.getLignes().add(nouvelleLigne);
        panierRepository.save(panier);

        return nouvelleLigne;
    }
}
