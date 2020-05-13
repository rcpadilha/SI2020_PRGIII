package br.edu.unisep.bugreport.bean;

import br.edu.unisep.bugreport.model.entity.Bug;
import br.edu.unisep.bugreport.usecase.NewBugUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NewBugBean {

    @Getter @Setter
    private Bug bug = new Bug();

    private NewBugUseCase useCase = new NewBugUseCase();

    @PostConstruct
    public void init() {
        bug.setGravity(1);
        bug.setFrequency(1);
    }

    public String save() {
        useCase.execute(bug);
        return "index?faces-redirect=true";
    }
}
