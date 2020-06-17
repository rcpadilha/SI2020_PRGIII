package br.edu.unisep.trainingmanager.dto.training;

import br.edu.unisep.trainingmanager.usecase.training.ListTrainingsUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListTrainingBean {

    @Getter
    @Setter
    private List<TrainingDto> trainings;

    @PostConstruct
    public void initialize() {
        var useCase = new ListTrainingsUseCase();
        trainings = useCase.execute();
    }
}
