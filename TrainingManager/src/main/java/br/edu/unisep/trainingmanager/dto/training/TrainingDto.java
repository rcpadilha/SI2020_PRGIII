package br.edu.unisep.trainingmanager.dto.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDto {

    private String user;
    private String name;
    private Integer frequency;

}
