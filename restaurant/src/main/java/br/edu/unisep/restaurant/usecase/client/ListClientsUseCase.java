package br.edu.unisep.restaurant.usecase.client;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.restaurant.dto.client.ClientDto;
import br.edu.unisep.restaurant.model.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ListClientsUseCase {

    public List<ClientDto> execute() {
        var dao = new HibernateDao<Client>();
        var clients = dao.findAll(Client.class);

        return clients.stream().map(client ->
                ClientDto.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .build()
        ).collect(Collectors.toList());
    }

}
