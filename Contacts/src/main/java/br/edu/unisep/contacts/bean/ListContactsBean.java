package br.edu.unisep.contacts.bean;

import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.usecase.DeleteContactUseCase;
import br.edu.unisep.contacts.usecase.ListContactsUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListContactsBean {

    private ListContactsUseCase listUseCase = new ListContactsUseCase();
    private DeleteContactUseCase deleteUseCase = new DeleteContactUseCase();

    @Getter @Setter
    private List<Contact> allContacts;

    @PostConstruct
    public void init() {
        this.allContacts = listUseCase.execute();
    }

    public void delete(Integer id) {
        deleteUseCase.execute(id);
        init();
    }

}
