package com.project.api.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Options {

    @ApiModelProperty(example = "John")
    @JsonProperty("text")
    private String textCorrected;

    @JsonProperty("score")
    private double score;

    @JsonProperty("freq")
    private double frequency;
}
