package org.example.ms_produit.Servie;

import org.example.ms_produit.Entity.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> findAll();
    Produit findById(String id);
    Produit save(Produit produit);
    void deleteById(String id);
}
