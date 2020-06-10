package br.edu.unisep.blog.model.dao;

import br.edu.unisep.blog.model.entity.User;
import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.hibernate.factory.HibernateSessionFactory;

public class UserDao extends HibernateDao<User> {

    public User findByLogin(String login) {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from User where login = :LOGIN", User.class);
        query.setParameter("LOGIN", login);

        var user = query.uniqueResult();
        session.close();

        return user;
    }

}
