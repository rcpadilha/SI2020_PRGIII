package br.edu.unisep.restaurant.bean.user;

import br.edu.unisep.restaurant.dto.login.UserDto;
import br.edu.unisep.restaurant.usecase.login.LoginUserUseCase;
import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private LoginUserUseCase useCase = new LoginUserUseCase();

    @Getter
    private UserDto user;

    public void loadUser(String login) {
        user = useCase.execute(login);
    }

    public void clearUser() {
        this.user = null;
    }
}
