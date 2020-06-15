package br.edu.unisep.trainingmanager.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "training_exercises")
public class TrainingExercise {

    @Id
    @Column(name = "id_trainingexercise")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_training")
    private Training training;

    @OneToOne
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

}
