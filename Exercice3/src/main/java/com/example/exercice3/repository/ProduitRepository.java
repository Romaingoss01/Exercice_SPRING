package com.example.exercice3.repository;

import com.example.exercice3.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
