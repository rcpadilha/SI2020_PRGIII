package br.edu.unisep.prestacoes.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestacaoDto {

    private Double valorCompra;
    private Double taxaJuros;

    private Integer parcelas;
    private Integer tipoJuros = 1;

}
