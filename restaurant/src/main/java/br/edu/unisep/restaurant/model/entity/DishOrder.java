package br.edu.unisep.restaurant.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dish_order")
public class DishOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dishorder")
    private Integer id;

    private Dish dish;

    private Order order;
}
