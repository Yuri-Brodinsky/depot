package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.trip.Trip;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String login;
    private String password;
    private Role role;
    @ManyToMany(mappedBy = "users")
    private Set<Trip> trips;
    public User(String login,String password,Role role){
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
