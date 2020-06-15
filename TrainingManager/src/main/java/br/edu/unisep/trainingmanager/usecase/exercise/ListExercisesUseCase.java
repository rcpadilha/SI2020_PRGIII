package br.edu.unisep.trainingmanager.usecase.exercise;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.trainingmanager.dto.exercise.ExerciseDto;
import br.edu.unisep.trainingmanager.model.entity.Exercise;

import java.util.List;
import java.util.stream.Collectors;

public class ListExercisesUseCase {

    public List<ExerciseDto> execute() {
        var dao = new HibernateDao<Exercise>();
        var exercises = dao.findAll(Exercise.class);

        return exercises.stream().map(e ->
                ExerciseDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .build())
                .collect(Collectors.toList());
    }

}
