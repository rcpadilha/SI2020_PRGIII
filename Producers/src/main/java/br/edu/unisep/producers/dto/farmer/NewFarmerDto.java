package br.edu.unisep.producers.dto.farmer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewFarmerDto {

    private String name;
    private String phone;
    private Integer communityId;

}
