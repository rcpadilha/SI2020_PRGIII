package br.edu.unisep.producers.dto.farmer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewFarmerDto {

    private String name;
    private String phone;
    private Integer communityId;

    private List<FarmerProduceDto> produces;
}
