package br.edu.unisep.restaurant.bean.client;

import br.edu.unisep.restaurant.dto.client.ClientDto;
import br.edu.unisep.restaurant.usecase.client.ListClientsUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListClientsBean {

    @Getter
    @Setter
    private List<ClientDto> clients;

    @PostConstruct
    public void initialize() {
        var useCase = new ListClientsUseCase();
        this.clients = useCase.execute();
    }
}
