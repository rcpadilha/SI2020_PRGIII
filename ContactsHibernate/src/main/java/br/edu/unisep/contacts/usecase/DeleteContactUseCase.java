package br.edu.unisep.contacts.usecase;

import br.edu.unisep.contacts.model.dao.ContactDao;

public class DeleteContactUseCase {

    public void execute(Integer id) {
        var dao = new ContactDao();
        dao.delete(id);
    }
}
