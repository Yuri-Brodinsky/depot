package com.examplestudy.depotapp.route;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalTime;

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
    @Column(name="path_length")
    private int pathLength;
    @Column(name="time_travel")
    private LocalTime timeTravel;
    public Route(String from,String to,int pathLength,LocalTime timeTravel){
        this.from = from;
        this.to = to;
        this.pathLength = pathLength;
        this.timeTravel = timeTravel;
    }
    public String toString(){
        return from+"-"+to;
    }
}

