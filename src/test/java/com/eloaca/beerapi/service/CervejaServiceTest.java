package com.eloaca.beerapi.service;

import com.eloaca.beerapi.domain.dtos.CervejaDTO;
import com.eloaca.beerapi.domain.entitys.Cerveja;
import com.eloaca.beerapi.domain.enums.MedidaCerveja;
import com.eloaca.beerapi.domain.enums.TipoCerveja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

    @BeforeEach
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
        CervejaDTO dto = bean.consultarCerveja(1L);
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
        return new CervejaDTO("Becks", MedidaCerveja.ML, "350", TipoCerveja.PURO_MALTE);
    }
}