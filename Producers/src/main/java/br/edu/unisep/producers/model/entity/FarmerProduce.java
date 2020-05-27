package br.edu.unisep.producers.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="farmer_produce")
public class FarmerProduce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_farmerproduce")
    private Integer id;

    @Column(name="produce_price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="id_farmer")
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name="id_produce")
    private Produce produce;

}
