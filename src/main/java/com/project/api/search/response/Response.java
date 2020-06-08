package com.project.api.search.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.api.Property;
import lombok.Data;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class Response {

    private int took;
    @JsonProperty("timed_out")
    private boolean timedOut;
    @JsonProperty("_shards")
    private Shard shards;
    private Hit hits;

    public List<Property> getResultsProperty(ObjectMapper mapper) {

        return getHits().getHits().stream()
            .map(hit -> mapper.convertValue(hit.getSource(), Property.class))
            .collect(toList());
    }

    public List<Highlight> getResultsHighlight(ObjectMapper mapper) {

        return getHits().getHits().stream()
            .map(hit -> mapper.convertValue(hit.getHighlight(), Highlight.class))
            .collect(toList());
    }
}
