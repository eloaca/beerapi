package com.eloaca.beerapi.domain.entitys;

import com.eloaca.beerapi.domain.enums.MedidaCerveja;
import com.eloaca.beerapi.domain.enums.TipoCerveja;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MedidaCerveja medidaCerveja;

    @Column(nullable = false)
    private String quantidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCerveja tipoCerveja;

    public Cerveja (String nome, MedidaCerveja medidaCerveja, String quantidade, TipoCerveja tipoCerveja){
        this.nome = nome;
        this.medidaCerveja = medidaCerveja;
        this.quantidade = quantidade;
        this.tipoCerveja = tipoCerveja;
    }
}
