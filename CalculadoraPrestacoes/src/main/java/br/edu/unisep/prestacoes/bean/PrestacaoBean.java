package br.edu.unisep.prestacoes.bean;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Getter
@Setter
public class PrestacaoBean {

    private Double valorCompra;
    private Double taxaJuros;

    private Integer parcelas;
    private Integer tipoJuros = 1;

    private Double valorParcela;

    public void calcular() {
        if (tipoJuros == 1) {
            valorParcela = (valorCompra * (1 + (taxaJuros / 100d * parcelas))) / parcelas;
        } else {
            valorParcela = (valorCompra * Math.pow(1 + taxaJuros / 100d, parcelas)) / parcelas;
        }
    }

}
