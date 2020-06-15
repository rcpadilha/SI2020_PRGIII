package br.edu.unisep.trainingmanager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @Column(name = "id_exercise")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}
