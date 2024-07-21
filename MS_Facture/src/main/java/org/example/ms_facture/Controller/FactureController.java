package org.example.ms_facture.Controller;

import org.example.ms_facture.DTO.FactureDTO;
import org.example.ms_facture.DTO.ProduitDTO;
import org.example.ms_facture.Entity.Facture;
import org.example.ms_facture.Service.IFactureService;
import org.example.ms_facture.Mappers.FactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factures")
public class FactureController {

    @Autowired
    private IFactureService factureService;

    @Autowired
    private FactureMapper factureMapper;

    @Value("${produit.service.url}")
    private String produitServiceUrl;

    @GetMapping
    public List<FactureDTO> getAllFactures() {
        List<Facture> factures = factureService.getAllFactures();
        return factures.stream()
                .map(factureMapper::toFactureDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureDTO> getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id)
                .map(facture -> ResponseEntity.ok(factureMapper.toFactureDTO(facture)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FactureDTO> createFacture(@RequestBody FactureDTO factureDTO) {
        Facture facture = factureMapper.toFacture(factureDTO);
        Facture savedFacture = factureService.saveFacture(facture);
        return ResponseEntity.ok(factureMapper.toFactureDTO(savedFacture));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactureDTO> updateFacture(@PathVariable Long id, @RequestBody FactureDTO factureDTO) {
        return factureService.getFactureById(id)
                .map(facture -> {
                    facture.setDescription(factureDTO.getDescription());
                    facture.setAmount(factureDTO.getAmount());
                    facture.setDate(factureDTO.getDate());
                    facture.setProduitId(factureDTO.getProduitId());

                    Facture updatedFacture = factureService.saveFacture(facture);
                    return ResponseEntity.ok(factureMapper.toFactureDTO(updatedFacture));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/produit/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable String id) {
        ProduitDTO produitDTO = factureService.getProduitById(id);
        if (produitDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produitDTO);
    }
}
