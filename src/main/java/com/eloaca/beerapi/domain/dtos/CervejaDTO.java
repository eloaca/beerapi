package com.eloaca.beerapi.domain.dtos;

import com.eloaca.beerapi.domain.enums.MedidaCerveja;
import com.eloaca.beerapi.domain.enums.TipoCerveja;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CervejaDTO implements Serializable {

    private static final long serialVersionUID = 1055184146404298164L;

    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private MedidaCerveja medidaCerveja;

    @NotEmpty
    private String quantidade;

    @NotEmpty
    private TipoCerveja tipoCerveja;

    public CervejaDTO(String nome, MedidaCerveja medidaCerveja, String quantidade, TipoCerveja tipoCerveja){
        this.nome = nome;
        this.medidaCerveja = medidaCerveja;
        this.quantidade = quantidade;
        this.tipoCerveja = tipoCerveja;
    }
}
