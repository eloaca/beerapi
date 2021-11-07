package com.eloaca.beerapi.service;

import com.eloaca.beerapi.domain.dtos.CervejaDTO;
import com.eloaca.beerapi.exception.CervejaException;

import java.util.List;

public class CervejaServiceBean implements CervejaService {

    @Override
    public CervejaDTO salvarCerveja(CervejaDTO cerveja) {
        return null;
    }

    @Override
    public CervejaDTO consultarCerveja(Long id) throws CervejaException {
        return null;
    }

    @Override
    public List<CervejaDTO> consultarCervejas() throws CervejaException {
        return null;
    }

    @Override
    public boolean excluirCerveja(Long id) {
        return false;
    }
}
