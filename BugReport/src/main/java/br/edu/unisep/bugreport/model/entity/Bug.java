package br.edu.unisep.bugreport.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="bug")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bug")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="email_responsible")
    private String email;

    @Column(name="report_date")
    private LocalDate reportDate;

    @Column(name="gravity")
    private Integer gravity;

    @Column(name="frequency")
    private Integer frequency;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private Integer status;

}
