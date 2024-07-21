package org.example.ms_produit.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProduitDTO {
    private String id;
    private String nom;
    private String description;
    private Double prix;
    private Integer quantite;
}
