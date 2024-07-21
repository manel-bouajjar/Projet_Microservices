package org.example.ms_facture.DTO;

import lombok.Data;

@Data
public class ProduitDTO {
    private String id;
    private String nom;
    private String description;
    private double prix;
    private int quantite;
}
