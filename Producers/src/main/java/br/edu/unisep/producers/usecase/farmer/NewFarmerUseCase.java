package br.edu.unisep.producers.usecase.farmer;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.producers.dto.farmer.NewFarmerDto;
import br.edu.unisep.producers.model.entity.Community;
import br.edu.unisep.producers.model.entity.Farmer;

public class NewFarmerUseCase {

    public void execute(NewFarmerDto newFarmer) throws DaoException {
        var farmer = new Farmer();
        farmer.setName(newFarmer.getName());
        farmer.setPhone(newFarmer.getPhone());

        var community = new Community();
        community.setId(newFarmer.getCommunityId());

        farmer.setCommunity(community);

        var dao = new HibernateDao<Farmer>();
        dao.save(farmer);
    }

}
