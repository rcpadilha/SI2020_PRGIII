package br.edu.unisep.producers.usecase.farmer;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.producers.dto.farmer.FarmerDto;
import br.edu.unisep.producers.model.entity.Farmer;

import java.util.List;
import java.util.stream.Collectors;

public class ListFarmersUseCase {

    public List<FarmerDto> execute() {
        var dao = new HibernateDao<Farmer>();
        var farmers = dao.findAll(Farmer.class);

        return farmers.stream().map(farmer ->
            FarmerDto.builder()
                .name(farmer.getName())
                .phone(farmer.getPhone())
                .community(farmer.getCommunity().getName())
                .build()
            ).collect(Collectors.toList());
    }

}
