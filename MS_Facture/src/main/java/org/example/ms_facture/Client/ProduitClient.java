package org.example.ms_facture.Client;

import org.example.ms_facture.DTO.ProduitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produit-service", url = "${produit.service.url}")
public interface ProduitClient {

    @GetMapping("/{id}")
    ProduitDTO getProduitById(@PathVariable("id") Long id);
}
