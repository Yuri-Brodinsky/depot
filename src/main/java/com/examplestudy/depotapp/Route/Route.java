package com.examplestudy.depotapp.Route;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="start_point")
    private String from;
    @Column(name="end_point")
    private String to;
    @Column(name="pathLength")
    private int pathLength;
    @Column(name="timeTravel")
    private int timeTravel;
    public Route(String from,String to,int pathLength,int timeTravel){
        this.from = from;
        this.to = to;
        this.pathLength = pathLength;
        this.timeTravel = timeTravel;
    }
}

