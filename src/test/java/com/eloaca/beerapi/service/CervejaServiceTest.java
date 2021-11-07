package com.eloaca.beerapi.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CervejaServiceTest {

    @Mock
    private CervejaRepository repository;

    private CervejaMapper mapper;

    @InjectMocks
    private CervejaServiceBean bean;

    @BeforeTestMethod
    void before(){
        mapper = new CervejaMapper();
    }

    @Test
    void salvarUmaNovaCerveja() {
        Cerveja cerveja = mapper.toCerveja(getCervejaDTO());
        when(repository.save(Cerveja.class)).thenReturn(cerveja);
        Cerveja dto = bean.salvarCerveja(mapper.toCerveja(getCervejaDTO()));
        assertNotNull(dto);
        assertNotNull(mapper.toCerveja(dto));
    }

    @Test
    void consultarCerveja() {
        Cerveja cerveja = mapper.toCerveja(getCervejaDTO());
        when(repository.findById(1L)).thenReturn(cerveja);
        Cerveja dto = bean.consultarCerveja(1L);
        assertNotNull(dto);
        assertNotNull(mapper.toCerveja(dto));
    }

    @Test
    void consultarCervejas() {
        Cerveja cerveja = mapper.toCerveja(getCervejaDTO());
        List<Cerveja> cervejas = new ArrayList<>();
        cervejas.add(cerveja);
        when(repository.findAll()).thenReturn(cervejas);
        List<CervejaDTO> dtos = bean.consultarCervejas();
        assertNotNull(dtos);
        assertNotNull(mapper.toCerveja(dtos.stream().map(CervejaDTO::new)));
    }

    @Test
    void excluirCerveja() {
        Cerveja cerveja = mapper.toCerveja(getCervejaDTO());
        when(repository.delete(cerveja));
        boolean b = bean.excluirCerveja(1L);
        assertTrue(b);
    }

    public CervejaDTO getCervejaDTO() {
        return new CervejaDTO("Becks", MediaCerveja.ML, "350", TipoCerveja.MALTE);
    }
}