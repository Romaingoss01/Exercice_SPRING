package com.example.exercice3.service;

import com.example.exercice3.entity.LignePanier;
import com.example.exercice3.entity.Panier;
import com.example.exercice3.entity.Produit;
import com.example.exercice3.repository.LignePanierRepository;
import com.example.exercice3.repository.PanierRepository;
import com.example.exercice3.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class PanierService {

    private final PanierRepository panierRepository;
    private final ProduitRepository produitRepository;
    private final LignePanierRepository lignePanierRepository;

    public PanierService(PanierRepository panierRepository, ProduitRepository produitRepository, LignePanierRepository lignePanierRepository) {
        this.panierRepository =  panierRepository;
        this.produitRepository = produitRepository;
        this.lignePanierRepository = lignePanierRepository;
    }

    public Panier ajouterProduitAuPanier(int panierId, int produitId, int quantite) {
        Panier panier = panierRepository.findById(panierId)
                .orElseThrow(() -> new RuntimeException("Panier introuvable"));
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));


        // Vérifier si le produit existe déjà dans le panier
        LignePanier ligneExistante = panier.getLignes().stream()
                .filter(lp -> lp.getProduit().getId()==(produitId))
                .findFirst()
                .orElse(null);

        if (ligneExistante != null) {
            // Produit déjà présent -> on augmente la quantité
            ligneExistante.setQuantite(ligneExistante.getQuantite() + quantite);
        } else {

            LignePanier ligne = new LignePanier();
            ligne.setPanier(panier);
            ligne.setProduit(produit);
            ligne.setQuantite(quantite);
            panier.getLignes().add(ligne);
        }

        return panierRepository.save(panier);
    }
}
