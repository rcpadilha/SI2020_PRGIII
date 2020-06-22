package br.edu.unisep.restaurant.bean.dish;

import br.edu.unisep.restaurant.dto.dish.DishDto;
import br.edu.unisep.restaurant.usecase.dish.ListDishesUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListDishesBean {

    @Getter
    @Setter
    private List<DishDto> dishes;

    @PostConstruct
    public void initialize() {
        var useCase = new ListDishesUseCase();
        this.dishes = useCase.execute();
    }
}
