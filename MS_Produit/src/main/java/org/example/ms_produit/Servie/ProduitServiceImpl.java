package org.example.ms_produit.Servie;

import org.example.ms_produit.Entity.Produit;
import org.example.ms_produit.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findById(String id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteById(String id) {
        produitRepository.deleteById(id);

    }
}
