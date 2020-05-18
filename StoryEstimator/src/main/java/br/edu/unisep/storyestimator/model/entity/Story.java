package br.edu.unisep.storyestimator.model.entity;

import lombok.Data;

@Data
public class Story {

    private Integer id;

    private String title;

    private String summary;

    private Integer pointsDev1;

    private Integer pointsDev2;

    private Integer pointsDev3;

    private Integer pointsDev4;

    private Integer pointsAverage;

    private Integer priority;

}
