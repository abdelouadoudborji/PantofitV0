package com.pantofit.porject1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Salle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String Code;
    @Column(length = 75)
    private String name;
    @Column(length = 75)
    private String description;
    @Column(length = 75)
    private String altitude;
    @Column(length = 75)
    private String longitude;
    @Column(length = 75)
    private String addressmail;
    @Column(length = 75)
    private String password;
    @ManyToOne
    private Ville ville;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "salle")
    private Set<Media> MediaList ;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "salle")
    private Set<Workout> WorkoutList ;
}
