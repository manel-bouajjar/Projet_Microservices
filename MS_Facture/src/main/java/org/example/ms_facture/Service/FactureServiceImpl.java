package org.example.ms_facture.Service;

import org.example.ms_facture.DTO.ProduitDTO;
import org.example.ms_facture.Entity.Facture;
import org.example.ms_facture.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Service

public class FactureServiceImpl implements IFactureService {

    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${produit.service.url}")
    private String produitServiceUrl;


    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    @Override
    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public ProduitDTO getProduitById(String id) {
        String url = produitServiceUrl + "/produits/" + id;
        return restTemplate.getForObject(url, ProduitDTO.class);
    }
}
