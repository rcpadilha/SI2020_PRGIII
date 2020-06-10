package br.edu.unisep.blog.usecase.user;

import br.edu.unisep.blog.dto.login.UserDto;
import br.edu.unisep.blog.model.dao.UserDao;

public class GetUserUseCase {

    public UserDto execute(String login) {
        var dao = new UserDao();
        var user = dao.findByLogin(login);

        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .build();
    }

}
