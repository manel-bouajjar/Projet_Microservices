package org.example.ms_produit.Mappers;


import org.example.ms_produit.DTO.ProduitDTO;
import org.example.ms_produit.Entity.Produit;
import org.springframework.stereotype.Service;

@Service
public class ProduitMapper {

    public ProduitDTO toDTO(Produit produit) {
        if (produit == null) {
            return null;
        }

        ProduitDTO dto = new ProduitDTO();
        dto.setId(produit.getId());
        dto.setNom(produit.getNom());
        dto.setDescription(produit.getDescription());
        dto.setPrix(produit.getPrix());
        dto.setQuantite(produit.getQuantite());
        return dto;
    }

    public Produit toEntity(ProduitDTO dto) {
        if (dto == null) {
            return null;
        }

        Produit produit = new Produit();
        produit.setId(dto.getId());
        produit.setNom(dto.getNom());
        produit.setDescription(dto.getDescription());
        produit.setPrix(dto.getPrix());
        produit.setQuantite(dto.getQuantite());
        return produit;
    }
}
