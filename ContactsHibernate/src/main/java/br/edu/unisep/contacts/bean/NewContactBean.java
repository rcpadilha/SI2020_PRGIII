package br.edu.unisep.contacts.bean;

import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.usecase.FindContactByIdUseCase;
import br.edu.unisep.contacts.usecase.SaveContactUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class NewContactBean {

    private SaveContactUseCase useCaseSave = new SaveContactUseCase();
    private FindContactByIdUseCase useCaseFind = new FindContactByIdUseCase();

    @Inject
    @RequestParameterMap
    private Map<String, String> params;

    @Getter
    @Setter
    private Contact contact = new Contact();

    @PostConstruct
    public void init() {
        var contactId = params.get("contactId");
        if (contactId != null) {
            contact = useCaseFind.execute(Integer.valueOf(contactId));
        }
    }

    public String save() {
        useCaseSave.execute(contact);

        return "index?faces-redirect=true";
    }
}
