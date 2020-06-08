package com.project.api;

import com.project.api.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Owner extends User {
    private List<Property> propertyList;
}
