package br.edu.unisep.bugreport.bean;

import br.edu.unisep.bugreport.model.entity.Bug;
import br.edu.unisep.bugreport.usecase.ListBugsUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListBugsBean {

    @Getter @Setter
    private List<Bug> bugs;

    private ListBugsUseCase listUseCase = new ListBugsUseCase();

    @PostConstruct
    public void init() {
        this.bugs = listUseCase.execute();
    }
}
