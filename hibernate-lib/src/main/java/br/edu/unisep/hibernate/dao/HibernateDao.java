package br.edu.unisep.hibernate.dao;

import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.hibernate.factory.HibernateSessionFactory;

import java.util.List;

public class HibernateDao<T> {

    public void save(T object) throws DaoException {
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try (session) {
            session.save(object);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();

            throw new DaoException(e);
        }
    }

    public List<T> findAll(Class<T> classe) {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from " + classe.getName(), classe);
        var result = query.list();

        session.close();

        return result;
    }

    public T findById(Integer id, Class<T> classe) {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from " + classe.getName() + " where id = :ID", classe);
        query.setParameter("ID", id);

        var contact = query.uniqueResult();

        session.close();
        return contact;
    }

    public void delete(T object) throws DaoException{
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try (session){
            session.delete(object);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();

            throw new DaoException(e);
        }
    }

    public void update(T object) throws DaoException{
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try (session){
            session.update(object);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();

            throw new DaoException(e);
        }
    }
}