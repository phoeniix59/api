package com.project.api.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class HitValue {

    @JsonProperty("_index")
    private String index;
    @JsonProperty("_type")
    private String type;
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_score")
    private double score;
    @JsonProperty("_source")
    private Map<String, Object> source;
    @JsonProperty("highlight")
    private Highlight highlight;
}
