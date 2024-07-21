package org.example.ms_produit.Entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document (collection = "produits")
public class Produit {
    @Id
    private String id;
    private String nom;
    private String description;
    private Double prix;
    private Integer quantite;

}
