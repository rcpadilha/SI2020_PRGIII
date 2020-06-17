package br.edu.unisep.trainingmanager.usecase.training;

import br.edu.unisep.hibernate.dao.HibernateDao;
import br.edu.unisep.hibernate.exception.DaoException;
import br.edu.unisep.trainingmanager.dto.training.NewTrainingDto;
import br.edu.unisep.trainingmanager.model.entity.Exercise;
import br.edu.unisep.trainingmanager.model.entity.Training;
import br.edu.unisep.trainingmanager.model.entity.TrainingExercise;
import br.edu.unisep.trainingmanager.model.entity.User;

import java.util.stream.Collectors;

public class NewTrainingUseCase {

    public void execute(NewTrainingDto newTraining) throws DaoException {
        var training = new Training();
        training.setFrequency(newTraining.getFrequency());
        training.setName(newTraining.getName());

        var user = new User();
        user.setLogin(newTraining.getUserId());

        training.setUser(user);

        var trainingExercises = newTraining.getExercises().stream().map(e -> {
            var te = new TrainingExercise();

            var exercise = new Exercise();
            exercise.setId(e.getId());

            te.setExercise(exercise);
            te.setTraining(training);

            return te;
        }).collect(Collectors.toList());

        training.setExercises(trainingExercises);

        var dao = new HibernateDao<Training>();
        dao.save(training);
    }

}
