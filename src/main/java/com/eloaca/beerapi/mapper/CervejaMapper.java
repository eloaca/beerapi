package com.eloaca.beerapi.mapper;

import com.eloaca.beerapi.domain.dtos.CervejaDTO;
import com.eloaca.beerapi.domain.entitys.Cerveja;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CervejaMapper {

    CervejaMapper INSTANCE = Mappers.getMapper(CervejaMapper.class);

    CervejaDTO toDTO(Cerveja cerveja);

    Cerveja toCerveja(CervejaDTO dto);
}
