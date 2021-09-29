package com.examplestudy.depotapp.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private int timeTravel;
    public Route(String from,String to,int pathLength,int timeTravel){
        this.from = from;
        this.to = to;
        this.pathLength = pathLength;
        this.timeTravel = timeTravel;
    }
    public String toString(){
        return from+"-"+to;
    }
}

