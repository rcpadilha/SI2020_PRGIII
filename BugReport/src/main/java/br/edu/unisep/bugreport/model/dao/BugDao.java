package br.edu.unisep.bugreport.model.dao;

import br.edu.unisep.bugreport.model.entity.Bug;
import br.edu.unisep.bugreport.model.hibernate.HibernateSessionFactory;

import java.util.List;

public class BugDao {

    public List<Bug> findAll() {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from Bug", Bug.class);
        var result = query.list();

        session.close();
        return result;
    }

    public void save(Bug bug) {
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try {
            session.save(bug);
            trans.commit();
        } catch(Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
    }

}
