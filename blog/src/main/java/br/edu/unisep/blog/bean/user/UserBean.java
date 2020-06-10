package br.edu.unisep.blog.bean.user;

import br.edu.unisep.blog.dto.login.UserDto;
import br.edu.unisep.blog.usecase.user.GetUserUseCase;
import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private GetUserUseCase useCase = new GetUserUseCase();

    @Getter
    private UserDto user;

    public void loadUser(String login) {
        user = useCase.execute(login);
    }
}
