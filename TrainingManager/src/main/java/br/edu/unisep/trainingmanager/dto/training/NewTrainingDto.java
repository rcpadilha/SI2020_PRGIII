package br.edu.unisep.trainingmanager.dto.training;

import br.edu.unisep.trainingmanager.dto.exercise.ExerciseDto;
import lombok.Data;

import java.util.List;

@Data
public class NewTrainingDto {

    private String userId;
    private String name;

    private Integer frequency;

    private List<ExerciseDto> exercises;

}
