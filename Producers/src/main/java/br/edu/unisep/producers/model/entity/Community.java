package br.edu.unisep.producers.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="communities")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_community")
    private Integer id;

    @Column(name="community_name")
    private String name;

}
