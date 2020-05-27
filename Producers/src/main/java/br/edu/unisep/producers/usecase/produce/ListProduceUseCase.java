package br.edu.unisep.producers.usecase.produce;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.producers.dto.produce.ProduceDto;
import br.edu.unisep.producers.model.entity.Produce;

import java.util.List;
import java.util.stream.Collectors;

public class ListProduceUseCase {

    public List<ProduceDto> execute() {
        var dao = new HibernateDao<Produce>();
        var produces = dao.findAll(Produce.class);

        return produces.stream().map(p ->
                ProduceDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .build()
        ).collect(Collectors.toList());
    }
}