package br.edu.unisep.hibernate.factory;

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
