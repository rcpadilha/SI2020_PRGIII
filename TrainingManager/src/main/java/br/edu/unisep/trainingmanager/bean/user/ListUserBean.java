package br.edu.unisep.trainingmanager.bean.user;

import br.edu.unisep.trainingmanager.dto.login.UserDto;
import br.edu.unisep.trainingmanager.usecase.user.ListUsersUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListUserBean {

    @Getter
    @Setter
    private List<UserDto> users;

    @PostConstruct
    public void initialize() {
        var useCase = new ListUsersUseCase();
        users = useCase.execute();
    }

}
