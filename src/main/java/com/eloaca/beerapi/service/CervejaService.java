package com.eloaca.beerapi.service;

public interface CervejaService {

    CervejaDTO salvarCerveja(CervejaDTO cerveja);

    CervejaDTO consultarCerveja(Long id) throws CervejaException;

    List<CervejaDTO> consultarCervejas();

    boolean excluirCerveja(Long id);
}
