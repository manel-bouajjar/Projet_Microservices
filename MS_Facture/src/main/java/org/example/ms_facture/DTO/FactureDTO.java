package org.example.ms_facture.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FactureDTO {

    private Long id;
    private String description;
    private double amount;
    private LocalDate date;
    private String produitId; // ID du produit associé
}
