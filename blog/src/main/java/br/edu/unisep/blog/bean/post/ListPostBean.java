package br.edu.unisep.blog.bean.post;

import br.edu.unisep.blog.bean.user.UserBean;
import br.edu.unisep.blog.dto.post.PostDto;
import br.edu.unisep.blog.usecase.post.FindPostsUseCase;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListPostBean {

    @Inject
    private UserBean userBean;

    @Getter
    @Setter
    private List<PostDto> posts;

    @PostConstruct
    public void init() {
        var useCase = new FindPostsUseCase();
        posts = useCase.execute(userBean.getUser().getLogin());
    }

}
