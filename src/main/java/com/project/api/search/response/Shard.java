package com.project.api.search.response;

import lombok.Data;

@Data
public class Shard {

    private long total;
    private long successful;
    private long skipped;
    private long failed;

}
