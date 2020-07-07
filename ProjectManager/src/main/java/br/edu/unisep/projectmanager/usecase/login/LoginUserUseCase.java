package br.edu.unisep.projectmanager.usecase.login;


import br.edu.unisep.projectmanager.dto.login.UserDto;
import br.edu.unisep.projectmanager.model.dao.user.UserDao;

public class LoginUserUseCase {

    public UserDto execute(String login) {
        var dao = new UserDao();
        var user = dao.findByLogin(login);

        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .role(user.getRole().getRole().getName())
                .build();
    }

}
