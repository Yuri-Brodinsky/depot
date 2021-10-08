package com.examplestudy.depotapp.user;

import com.examplestudy.depotapp.security.Role;
import com.examplestudy.depotapp.trip.Trip;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
    public String toString(){
        return login;
    }
}
