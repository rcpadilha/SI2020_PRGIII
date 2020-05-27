package br.edu.unisep.producers.bean.farmer;

import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.producers.dto.community.CommunityDto;
import br.edu.unisep.producers.dto.farmer.FarmerProduceDto;
import br.edu.unisep.producers.dto.farmer.NewFarmerDto;
import br.edu.unisep.producers.dto.produce.ProduceDto;
import br.edu.unisep.producers.usecase.community.ListCommunitiesUseCase;
import br.edu.unisep.producers.usecase.farmer.NewFarmerUseCase;
import br.edu.unisep.producers.usecase.produce.ListProduceUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
@ViewScoped
public class NewFarmerBean implements Serializable{

    private NewFarmerUseCase newFarmerUseCase = new NewFarmerUseCase();
    private ListCommunitiesUseCase listCommunitiesUseCase = new ListCommunitiesUseCase();
    private ListProduceUseCase listProduceUseCase = new ListProduceUseCase();

    @Getter @Setter
    private NewFarmerDto newFarmer = new NewFarmerDto();

    @Getter @Setter
    private FarmerProduceDto farmerProduce = new FarmerProduceDto();

    @Getter @Setter
    private List<CommunityDto> communities;

    @Getter @Setter
    private List<ProduceDto> produces;

    @PostConstruct
    public void init() {
        this.communities = listCommunitiesUseCase.execute();
        this.produces = listProduceUseCase.execute();

        this.newFarmer.setProduces(new ArrayList<>());
    }

    public String save() {
        try {
            newFarmerUseCase.execute(newFarmer);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "/farmers/listFarmers.xhtml?faces-redirect=true";
    }

    public void addProduce() {
        Optional<ProduceDto> produce = produces.stream().filter(
                p -> p.getId().equals(farmerProduce.getProduceId())
        ).findFirst();

        farmerProduce.setProduceName(produce.get().getName());

        this.newFarmer.getProduces().add(farmerProduce);
        this.farmerProduce = new FarmerProduceDto();
    }
}
