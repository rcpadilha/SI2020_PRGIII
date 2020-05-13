package br.edu.unisep.bugreport.usecase;

import br.edu.unisep.bugreport.model.dao.BugDao;
import br.edu.unisep.bugreport.model.entity.Bug;

import java.util.List;

public class ListBugsUseCase {

    public List<Bug> execute() {
        var dao = new BugDao();
        return dao.findAll();
    }
}
