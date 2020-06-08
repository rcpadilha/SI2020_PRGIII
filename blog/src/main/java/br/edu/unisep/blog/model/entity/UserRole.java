package br.edu.unisep.blog.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "id_userrole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "login")
    private User user;

    @OneToOne
    @JoinColumn(name = "role_name")
    private Role role;

}
