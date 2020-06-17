package br.edu.unisep.trainingmanager.bean.training;

import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.trainingmanager.dto.exercise.ExerciseDto;
import br.edu.unisep.trainingmanager.dto.training.NewTrainingDto;
import br.edu.unisep.trainingmanager.usecase.training.NewTrainingUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@ViewScoped
public class NewTrainingBean implements Serializable {

    @Getter
    @Setter
    private NewTrainingDto newTraining;

    @PostConstruct
    public void initialize() {
        this.newTraining = new NewTrainingDto();
        this.newTraining.setExercises(new ArrayList<>());
    }

    public void addExercise(ExerciseDto exercise) {
        newTraining.getExercises().add(exercise);
    }

    public void removeExercise(ExerciseDto exercise) {
        newTraining.getExercises().remove(exercise);
    }

    public boolean isInList(ExerciseDto exercise) {
        return newTraining.getExercises().contains(exercise);
    }

    public String save() {
        try {
            var useCase = new NewTrainingUseCase();
            useCase.execute(newTraining);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        return "/app/trainings.xhtml?faces-redirect=true";
    }

}
