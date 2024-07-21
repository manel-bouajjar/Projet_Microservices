package org.example.ms_facture.Repository;


import org.example.ms_facture.Entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}