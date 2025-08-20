package com.example.exercice3.controller;

import com.example.exercice3.entity.Panier;
import com.example.exercice3.service.PanierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/panier")
public class PanierController {

    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }


    @GetMapping("/addProduit/{panierId}/{produitId}")
    public Panier ajouterProduit(@PathVariable int panierId, @PathVariable int produitId, @RequestParam int quantite) {
        return panierService.ajouterProduitAuPanier(panierId, produitId, quantite);
    }


}
