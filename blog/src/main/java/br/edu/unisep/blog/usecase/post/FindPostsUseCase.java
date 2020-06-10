package br.edu.unisep.blog.usecase.post;

import br.edu.unisep.blog.dto.post.PostDto;
import br.edu.unisep.blog.model.dao.PostDao;

import java.util.List;
import java.util.stream.Collectors;

public class FindPostsUseCase {

    public List<PostDto> execute(String login) {
        var dao = new PostDao();
        var result = dao.findByUser(login);

        return result.stream().map(post ->
            PostDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .date(post.getDate())
                .build()
        ).collect(Collectors.toList());
    }

}
