package br.edu.unisep.restaurant.dto.order;

import br.edu.unisep.restaurant.model.entity.Dish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class NewOrderDto {

    private Integer clientId;
    private LocalDateTime date;
    private Double total;
    private List<Dish> dishes;
}
