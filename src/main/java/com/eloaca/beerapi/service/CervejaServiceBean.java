package com.eloaca.beerapi.service;

import com.eloaca.beerapi.domain.dtos.CervejaDTO;
import com.eloaca.beerapi.domain.entitys.Cerveja;
import com.eloaca.beerapi.exception.CervejaException;
import com.eloaca.beerapi.mapper.CervejaMapper;
import com.eloaca.beerapi.repository.CervejaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CervejaServiceBean implements CervejaService {

    private final CervejaRepository repository;

    private final CervejaMapper mapper = CervejaMapper.INSTANCE;

    @Override
    public CervejaDTO salvarCerveja(CervejaDTO dto) {
        Cerveja cerveja = repository.save(mapper.toModel(dto));
        return mapper.toDTO(cerveja);
    }

    @Override
    public CervejaDTO consultarCerveja(Long id) throws CervejaException {
        Optional<Cerveja> cerveja = repository.findById(id);
        return mapper.toDTO(cerveja.orElseThrow(() -> new CervejaException("Cerveja Nao Encontrada")));
    }

    @Override
    public List<CervejaDTO> consultarCervejas() throws CervejaException {
        List<Cerveja> cervejas = repository.findAll();

        if (!cervejas.isEmpty()) {
            List<CervejaDTO> dtos = new ArrayList<>();
            cervejas.forEach(cerveja -> dtos.add(mapper.toDTO(cerveja)));
            return dtos;
        } else {
            throw new CervejaException("Nao foi encontrada nenhuma cerveja cadastrada");
        }

    }

    @Override
    public boolean excluirCerveja(Long id) {
        repository.deleteById(1L);
        return repository.findById(1L).isPresent();
    }
}
