package br.edu.unisep.producers.bean.farmer;

import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.producers.dto.community.CommunityDto;
import br.edu.unisep.producers.dto.farmer.NewFarmerDto;
import br.edu.unisep.producers.model.entity.FarmerProduce;
import br.edu.unisep.producers.usecase.community.ListCommunitiesUseCase;
import br.edu.unisep.producers.usecase.farmer.NewFarmerUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class NewFarmerBean {

    private NewFarmerUseCase newFarmerUseCase = new NewFarmerUseCase();
    private ListCommunitiesUseCase listCommunitiesUseCase = new ListCommunitiesUseCase();

    @Getter @Setter
    private NewFarmerDto newFarmer = new NewFarmerDto();

    @Getter @Setter
    private List<CommunityDto> communities;

    @PostConstruct
    public void init() {
        this.communities = listCommunitiesUseCase.execute();
    }

    public String save() {
        try {
            newFarmerUseCase.execute(newFarmer);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "/farmers/listFarmers.xhtml?faces-redirect=true";
    }
}
