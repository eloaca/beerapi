package com.eloaca.beerapi.service;

import com.eloaca.beerapi.domain.dtos.CervejaDTO;
import com.eloaca.beerapi.exception.CervejaException;

import java.util.List;

public interface CervejaService {

    CervejaDTO salvarCerveja(CervejaDTO cerveja);

    CervejaDTO consultarCerveja(Long id) throws CervejaException;

    List<CervejaDTO> consultarCervejas() throws CervejaException;

    boolean excluirCerveja(Long id);
}
