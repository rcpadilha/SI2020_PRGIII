package br.edu.unisep.storyestimator.model.dao;

import br.edu.unisep.storyestimator.model.entity.Story;
import br.edu.unisep.storyestimator.model.hibernate.HibernateSessionFactory;

import java.util.List;

public class StoryDao {

    public List<Story> findAll() {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from Story", Story.class);
        var result = query.list();

        session.close();
        return result;
    }

    public void save(Story bug) {
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try {
            session.save(bug);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            session.close();
        }
    }

}
