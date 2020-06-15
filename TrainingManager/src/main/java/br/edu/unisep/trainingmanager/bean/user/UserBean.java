package br.edu.unisep.trainingmanager.bean.user;

import br.edu.unisep.trainingmanager.dto.login.UserDto;
import br.edu.unisep.trainingmanager.usecase.user.GetUserUseCase;
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

    public void clearUser() {
        this.user = null;
    }
}
