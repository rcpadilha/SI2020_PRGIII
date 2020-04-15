package br.edu.unisep.contacts.model.dao;

import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.model.hibernate.HibernateSessionFactory;

import java.util.List;

public class ContactDao {

    public void save(Contact contact) {
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try {
            session.save(contact);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }

        session.close();
    }

    public List<Contact> findAll() {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from Contact", Contact.class);
        var result = query.list();

        session.close();

        return result;
    }

    public Contact findById(Integer id) {
        var session = HibernateSessionFactory.getSession();

        var query = session.createQuery("from Contact where id = :CONTACT_ID", Contact.class);
        query.setParameter("CONTACT_ID", id);

        var contact = query.uniqueResult();

        session.close();
        return contact;
    }

    public void delete(Contact contact) {
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try {
            session.delete(contact);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }

        session.close();
    }

    public void update(Contact contact) {
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();

        try {
            session.update(contact);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }

        session.close();
    }
}