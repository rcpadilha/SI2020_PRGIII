package br.edu.unisep.trainingmanager.bean.exercise;

import br.edu.unisep.trainingmanager.dto.exercise.ExerciseDto;
import br.edu.unisep.trainingmanager.usecase.exercise.ListExercisesUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListExercisesBean {

    @Getter
    @Setter
    private List<ExerciseDto> exercises;

    @PostConstruct
    public void initialize() {
        var useCase = new ListExercisesUseCase();
        exercises = useCase.execute();
    }

}
