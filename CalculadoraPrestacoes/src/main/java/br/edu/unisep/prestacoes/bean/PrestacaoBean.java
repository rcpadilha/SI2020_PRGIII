package br.edu.unisep.prestacoes.bean;

import br.edu.unisep.prestacoes.domain.dto.PrestacaoDto;
import br.edu.unisep.prestacoes.domain.usecase.CalcularValorParcelaUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Getter
@Setter
public class PrestacaoBean {

    private CalcularValorParcelaUseCase valorParcelaUseCase = new CalcularValorParcelaUseCase();
    private PrestacaoDto prestacao = new PrestacaoDto();

    private Double valorParcela;

    public void calcular() {
        valorParcela = valorParcelaUseCase.execute(prestacao);
    }

    public void limpar() {
        prestacao = new PrestacaoDto();
        valorParcela = null;
    }
}
