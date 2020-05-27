package br.edu.unisep.producers.dto.produce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProduceDto {

    private Integer id;
    private String name;

}
