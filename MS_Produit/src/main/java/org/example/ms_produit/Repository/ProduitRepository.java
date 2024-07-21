package org.example.ms_produit.Repository;

import org.example.ms_produit.Entity.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduitRepository extends MongoRepository<Produit, String> {
}