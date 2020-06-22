package br.edu.unisep.restaurant.usecase.dish;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.restaurant.dto.dish.DishDto;
import br.edu.unisep.restaurant.model.entity.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class ListDishesUseCase {

    public List<DishDto> execute() {
        var dao = new HibernateDao<Dish>();
        var clients = dao.findAll(Dish.class);

        return clients.stream().map(dish ->
                DishDto.builder()
                        .id(dish.getId())
                        .name(dish.getName())
                        .price(dish.getPrice())
                        .build()
        ).collect(Collectors.toList());
    }

}
