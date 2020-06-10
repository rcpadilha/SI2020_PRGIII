package br.edu.unisep.blog.usecase.post;

import br.edu.unisep.blog.dto.post.NewPostDto;
import br.edu.unisep.blog.model.dao.PostDao;
import br.edu.unisep.blog.model.entity.Post;
import br.edu.unisep.blog.model.entity.User;
import br.edu.unisep.hibernate.exception.DaoException;

import java.time.LocalDateTime;

public class NewPostUseCase {

    public void execute(NewPostDto newPost) {
        var dao = new PostDao();

        var post = new Post();
        post.setTitle(newPost.getTitle());
        post.setContent(newPost.getContent());
        post.setDate(LocalDateTime.now());

        var user = new User();
        user.setLogin(newPost.getUser());

        post.setUser(user);

        try {
            dao.save(post);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
