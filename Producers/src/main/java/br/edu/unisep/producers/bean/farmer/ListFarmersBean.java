package br.edu.unisep.producers.bean.farmer;

import br.edu.unisep.producers.dto.farmer.FarmerDto;
import br.edu.unisep.producers.usecase.farmer.ListFarmersUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListFarmersBean {

    @Getter @Setter
    private List<FarmerDto> farmers;

    @PostConstruct
    public void init() {
        var listUseCase = new ListFarmersUseCase();
        this.farmers = listUseCase.execute();
    }

}
