package com.eloaca.beerapi.service;

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
    public List<CervejaDTO> consultarCervejas() {
        return null;
    }

    @Override
    public boolean excluirCerveja(Long id) {
        return false;
    }
}