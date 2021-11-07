package com.eloaca.beerapi.service;

import com.eloaca.beerapi.domain.dtos.CervejaDTO;
import com.eloaca.beerapi.domain.entitys.Cerveja;
import com.eloaca.beerapi.domain.enums.MedidaCerveja;
import com.eloaca.beerapi.domain.enums.TipoCerveja;
import com.eloaca.beerapi.exception.CervejaException;
import com.eloaca.beerapi.mapper.CervejaMapper;
import com.eloaca.beerapi.repository.CervejaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CervejaServiceTest {

    @Mock
    private CervejaRepository repository;

    private final CervejaMapper mapper = CervejaMapper.INSTANCE;;

    @InjectMocks
    private CervejaServiceBean bean;

    @Test
    void salvarUmaNovaCerveja() {
        Cerveja cerveja = mapper.toModel(getCervejaDTO());
        when(repository.save(any(Cerveja.class))).thenReturn(cerveja);
        CervejaDTO dto = bean.salvarCerveja(getCervejaDTO());
        assertNotNull(dto);
        assertNotNull(mapper.toModel(dto));
    }

    @Test
    void consultarCerveja() throws CervejaException {
        Cerveja cerveja = mapper.toModel(getCervejaDTO());
        when(repository.findById(1L)).thenReturn(java.util.Optional.ofNullable(cerveja));
        CervejaDTO dto = bean.consultarCerveja(1L);
        assertNotNull(dto);
        assertNotNull(mapper.toModel(dto));
    }

    @Test
    void consultarCervejas() throws CervejaException {
        Cerveja cerveja = mapper.toModel(getCervejaDTO());
        List<Cerveja> cervejas = new ArrayList<>();
        cervejas.add(cerveja);
        when(repository.findAll()).thenReturn(cervejas);
        List<CervejaDTO> dtos = bean.consultarCervejas();
        assertNotNull(dtos);
    }

    @Test
    void excluirCerveja() {
        doNothing().when(repository).deleteById(1L);
        boolean b = bean.excluirCerveja(1L);
        assertTrue(b);
    }

    public CervejaDTO getCervejaDTO() {
        return new CervejaDTO("Becks", MedidaCerveja.ML, "350", TipoCerveja.PURO_MALTE);
    }
}