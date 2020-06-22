package br.edu.unisep.restaurant.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "total")
    private Double total;

    private List<DishOrder> dishes;

    private Client client;
}
