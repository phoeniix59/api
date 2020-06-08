package com.project.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ref;
    private String type;
    private String title;
    private List<String> characteristicList;
    private String availability;
    private Owner owner;
    private List<Reservation> reservationList;
    private List<Album> albumList;
    private Address address;
}
