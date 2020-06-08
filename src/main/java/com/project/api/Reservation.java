package com.project.api;

import com.project.api.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
    private String ref;
    private User user;
    private Property property;
    private String startDate;
    private String endDate;
}
