package br.edu.unisep.trainingmanager.usecase.training;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.trainingmanager.dto.training.TrainingDto;
import br.edu.unisep.trainingmanager.model.entity.Training;

import java.util.List;
import java.util.stream.Collectors;

public class ListTrainingsUseCase {

    public List<TrainingDto> execute() {
        var dao = new HibernateDao<Training>();
        var trainings = dao.findAll(Training.class);

        return trainings.stream().map(t ->
                TrainingDto.builder()
                        .user(t.getUser().getName())
                        .name(t.getName())
                        .frequency(t.getFrequency())
                        .build())
                .collect(Collectors.toList());
    }

}
