package br.edu.unisep.trainingmanager.usecase.user;

import br.edu.unisep.trainingmanager.dto.login.UserDto;
import br.edu.unisep.trainingmanager.model.dao.UserDao;

import java.util.List;
import java.util.stream.Collectors;

public class ListUsersUseCase {

    public List<UserDto> execute() {

        var dao = new UserDao();
        var users = dao.findUsers();

        return users.stream().map(u ->
                UserDto.builder()
                        .login(u.getLogin())
                        .name(u.getName())
                        .build()
        ).collect(Collectors.toList());
    }

}
