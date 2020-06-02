package br.edu.unisep.blog.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
