package br.edu.unisep.blog.dto.post;

import lombok.Data;

@Data
public class NewPostDto {

    private String title;
    private String content;
    private String user;

}
