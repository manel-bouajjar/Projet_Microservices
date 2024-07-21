package org.example.ms_produit.Controller;

import org.example.ms_produit.DTO.ProduitDTO;
import org.example.ms_produit.Entity.Produit;

import org.example.ms_produit.Mappers.ProduitMapper;
import org.example.ms_produit.Servie.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private ProduitMapper produitMapper;

    @GetMapping
    public List<ProduitDTO> getAllProduits() {
        List<Produit> produits = produitService.findAll();
        return produits.stream()
                .map(produitMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable String id) {
        Produit produit = produitService.findById(id);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }
        ProduitDTO produitDTO = produitMapper.toDTO(produit);
        return ResponseEntity.ok(produitDTO);
    }

    @PostMapping
    public ProduitDTO createProduit(@RequestBody ProduitDTO produitDTO) {
        Produit produit = produitMapper.toEntity(produitDTO);
        Produit savedProduit = produitService.save(produit);
        return produitMapper.toDTO(savedProduit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitDTO> updateProduit(@PathVariable String id, @RequestBody ProduitDTO produitDetails) {
        Produit produit = produitService.findById(id);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }

        produit.setNom(produitDetails.getNom());
        produit.setDescription(produitDetails.getDescription());
        produit.setPrix(produitDetails.getPrix());
        produit.setQuantite(produitDetails.getQuantite());

        Produit updatedProduit = produitService.save(produit);
        ProduitDTO updatedProduitDTO = produitMapper.toDTO(updatedProduit);
        return ResponseEntity.ok(updatedProduitDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable String id) {
        Produit produit = produitService.findById(id);
        if (produit == null) {
            return ResponseEntity.notFound().build();
        }

        produitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
