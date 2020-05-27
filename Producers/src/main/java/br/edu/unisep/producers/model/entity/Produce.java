package br.edu.unisep.producers.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="produce")
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produce")
    private Integer id;

    @Column(name="produce_name")
    private String name;

}
