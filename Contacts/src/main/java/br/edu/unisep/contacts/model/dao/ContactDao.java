package br.edu.unisep.contacts.model.dao;

import br.edu.unisep.contacts.model.entity.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        var connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_contacts",
                "postgres", "admin");

        return connection;
    }

    public void save(Contact contact) {

        try {
            var connection = connect();

            var ps = connection.prepareStatement("insert into contacts(name, email) values (?, ?)");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());

            ps.execute();

            ps.close();
            connection.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Contact> findAll() {

        var allContacts = new ArrayList<Contact>();

        try {
            var connection = connect();

            var st = connection.createStatement();
            var result = st.executeQuery("select * from contacts");

            while (result.next()) {
                var contact = new Contact();
                contact.setId( result.getInt("id_contact") );
                contact.setName( result.getString("name") );
                contact.setEmail( result.getString("email") );

                allContacts.add(contact);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return allContacts;
    }

}
