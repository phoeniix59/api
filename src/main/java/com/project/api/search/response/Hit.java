package com.project.api.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Hit {

    private long total;
    @JsonProperty("max_score")
    private int maxScore;
    private List<HitValue> hits;
}
