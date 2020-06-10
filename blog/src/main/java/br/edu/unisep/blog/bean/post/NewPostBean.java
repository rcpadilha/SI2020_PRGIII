package br.edu.unisep.blog.bean.post;

import br.edu.unisep.blog.bean.user.UserBean;
import br.edu.unisep.blog.dto.post.NewPostDto;
import br.edu.unisep.blog.usecase.post.NewPostUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NewPostBean {

    @Inject
    private UserBean userBean;

    @Getter
    @Setter
    private NewPostDto post = new NewPostDto();

    public String save() {
        var useCase = new NewPostUseCase();
        post.setUser(userBean.getUser().getLogin());

        useCase.execute(post);

        return "/app/home.xhtml?faces-redirect=true";
    }
}
