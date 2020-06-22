package br.edu.unisep.restaurant.dto.dish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishDto {

    private Integer id;
    private String name;
    private Double price;

}
