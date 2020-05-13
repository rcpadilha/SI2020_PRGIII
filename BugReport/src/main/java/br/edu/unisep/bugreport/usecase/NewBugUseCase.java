package br.edu.unisep.bugreport.usecase;

import br.edu.unisep.bugreport.model.dao.BugDao;
import br.edu.unisep.bugreport.model.entity.Bug;

public class NewBugUseCase {

    public void execute(Bug bug) {
        bug.setStatus(1);

        var dao = new BugDao();
        dao.save(bug);
    }
}
