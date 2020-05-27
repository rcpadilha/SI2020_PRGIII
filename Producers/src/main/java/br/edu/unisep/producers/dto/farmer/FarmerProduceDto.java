package br.edu.unisep.producers.dto.farmer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FarmerProduceDto {

    private Integer produceId;
    private String produceName;
    private Double price;

}
