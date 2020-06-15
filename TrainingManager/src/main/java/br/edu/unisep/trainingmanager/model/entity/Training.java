package br.edu.unisep.trainingmanager.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "training")
public class Training {

    @Id
    @Column(name = "id_training")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="id_user")
    private User user;

    @Column(name="frequency")
    private Integer frequency;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<TrainingExercise> exercises;

}
