package br.edu.unisep.prestacoes.domain.usecase;

import br.edu.unisep.prestacoes.domain.dto.PrestacaoDto;

public class CalcularValorParcelaUseCase {

    public Double execute(PrestacaoDto dadosPrestacao) {
        if (dadosPrestacao.getTipoJuros() == 1) {
            return (dadosPrestacao.getValorCompra() *
                    (1 + (dadosPrestacao.getTaxaJuros() / 100d * dadosPrestacao.getParcelas())))
                    / dadosPrestacao.getParcelas();
        } else {
            return (dadosPrestacao.getValorCompra() * Math.pow(1 + dadosPrestacao.getTaxaJuros()
                    / 100d, dadosPrestacao.getParcelas())) / dadosPrestacao.getParcelas();
        }
    }
}
