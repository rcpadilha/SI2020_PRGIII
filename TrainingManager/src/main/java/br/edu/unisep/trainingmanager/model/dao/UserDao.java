package br.edu.unisep.trainingmanager.model.dao;


import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.hibernate.factory.HibernateSessionFactory;
import br.edu.unisep.trainingmanager.model.entity.User;

import java.util.List;

public class UserDao extends HibernateDao<User> {

    public User findByLogin(String login) {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from User where login = :LOGIN", User.class);
        query.setParameter("LOGIN", login);

        var user = query.uniqueResult();
        session.close();

        return user;
    }

    public List<User> findUsers() {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from User where role.role.name = 'USER'");
        var users = query.list();

        session.close();

        return users;
    }

}
