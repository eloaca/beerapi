package com.eloaca.beerapi.repository;

import com.eloaca.beerapi.domain.entitys.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {
}
