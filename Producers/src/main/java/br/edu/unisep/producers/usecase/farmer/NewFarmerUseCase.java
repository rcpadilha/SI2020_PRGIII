package br.edu.unisep.producers.usecase.farmer;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.producers.dto.farmer.NewFarmerDto;
import br.edu.unisep.producers.model.entity.Community;
import br.edu.unisep.producers.model.entity.Farmer;
import br.edu.unisep.producers.model.entity.FarmerProduce;
import br.edu.unisep.producers.model.entity.Produce;

import java.util.stream.Collectors;

public class NewFarmerUseCase {

    public void execute(NewFarmerDto newFarmer) throws DaoException {
        var farmer = new Farmer();
        farmer.setName(newFarmer.getName());
        farmer.setPhone(newFarmer.getPhone());

        var community = new Community();
        community.setId(newFarmer.getCommunityId());

        farmer.setCommunity(community);

        // Para cada objeto FarmerProduceDto é gerado um novo objeto FarmerProduce
        var listProduces = newFarmer.getProduces().stream().map(prod -> {

            // Cria a entidade FarmerProduce
            var fp = new FarmerProduce();
            fp.setPrice(prod.getPrice());

            // Vincula o produtor à entidade FarmerProduce
            fp.setFarmer(farmer);

            // Cria um objeto Produce para receber o ID do produto selecionado na tela
            var produce = new Produce();
            produce.setId(prod.getProduceId());

            // Vincula o produto à entidade FarmerProduce
            fp.setProduce(produce);

            return fp;
        }).collect(Collectors.toList());

        farmer.setProduceList(listProduces);

        // Salva o farmer
        var dao = new HibernateDao<Farmer>();
        dao.save(farmer);
    }
}
