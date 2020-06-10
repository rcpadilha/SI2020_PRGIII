package br.edu.unisep.blog.model.dao;

import br.edu.unisep.blog.model.entity.Post;
import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.hibernate.factory.HibernateSessionFactory;

import java.util.List;

public class PostDao extends HibernateDao<Post> {

    public List<Post> findByUser(String login) {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from Post where user.login = :LOGIN order by date desc ", Post.class);
        query.setParameter("LOGIN", login);

        var result = query.list();
        session.close();

        return result;
    }

}
