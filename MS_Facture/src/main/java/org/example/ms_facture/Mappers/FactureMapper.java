package org.example.ms_facture.Mappers;

import org.example.ms_facture.DTO.FactureDTO;
import org.example.ms_facture.Entity.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FactureMapper {
    FactureMapper INSTANCE = Mappers.getMapper(FactureMapper.class);

    FactureDTO toFactureDTO(Facture facture);
    Facture toFacture(FactureDTO factureDTO);
}
