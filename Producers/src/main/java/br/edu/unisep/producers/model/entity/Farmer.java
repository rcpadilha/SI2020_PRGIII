package br.edu.unisep.producers.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_farmer")
    private Integer id;

    @Column(name = "farmer_name")
    private String name;

    @Column(name = "phone_number")
    private String phone;

    @OneToOne
    @JoinColumn(name = "id_community")
    private Community community;

    @OneToMany(mappedBy="farmer")
    private List<FarmerProduce> produceList;
}
