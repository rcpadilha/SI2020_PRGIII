package br.edu.unisep.blog.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_name")
    private Role role;

}
