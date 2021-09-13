package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.trip.Trip;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "depot_user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="login",unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @ManyToMany(mappedBy = "users")
    private Set<Trip> trips;
    public User(String login,String password,Role role){
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public void addTrip(Trip trip){
        trips.add(trip);
    }
    public void remove(Trip trip){trips.remove(trip);}

}
