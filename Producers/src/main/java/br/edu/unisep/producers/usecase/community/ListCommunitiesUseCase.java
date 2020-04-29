package br.edu.unisep.producers.usecase.community;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.producers.dto.community.CommunityDto;
import br.edu.unisep.producers.model.entity.Community;

import java.util.List;
import java.util.stream.Collectors;

public class ListCommunitiesUseCase {

    public List<CommunityDto> execute() {
        var dao = new HibernateDao<Community>();
        var result = dao.findAll(Community.class);

        return result.stream().map(entity ->
            CommunityDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build()
        ).collect(Collectors.toList());
    }
}
