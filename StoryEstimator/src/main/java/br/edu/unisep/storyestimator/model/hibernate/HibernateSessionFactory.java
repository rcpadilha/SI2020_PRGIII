package br.edu.unisep.storyestimator.model.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory factory;

    static {
        var configuration = new Configuration();
        configuration.configure();

        factory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return factory.openSession();
    }
}
