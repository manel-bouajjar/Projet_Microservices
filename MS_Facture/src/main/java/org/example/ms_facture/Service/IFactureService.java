package org.example.ms_facture.Service;

import org.example.ms_facture.DTO.ProduitDTO;
import org.example.ms_facture.Entity.Facture;

import java.util.List;
import java.util.Optional;

public interface IFactureService {
    List<Facture> getAllFactures();
    Optional<Facture> getFactureById(Long id);
    Facture saveFacture(Facture facture);
    void deleteFacture(Long id);
    ProduitDTO getProduitById(String id);
}
