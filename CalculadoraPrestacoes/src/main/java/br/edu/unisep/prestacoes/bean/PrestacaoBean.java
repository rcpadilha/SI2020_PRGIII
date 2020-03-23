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



    private Double valorParcela;



}
