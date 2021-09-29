package com.examplestudy.depotapp.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="lastNumber")
    private String lastName;
    @Column(name="birthYear")
    private LocalDate birthYear;
    @Column(name="employmentDate")
    private LocalDate employmentDate;
    public Driver(String name, String lastName,
                  LocalDate birthYear,LocalDate employmentDate){
        this.name = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.employmentDate = employmentDate;
    }

}
