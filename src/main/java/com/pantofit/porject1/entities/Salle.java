package com.pantofit.porject1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;
//checkpush
@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Salle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    @JsonIgnore
    private String code;
    @Column(length = 75)
    private String name;
    @Column(length = 75)
    private String description;
    @Column(length = 75)
    private String altitude;
    @Column(length = 75)
    private String longitude;
    @Column(length = 75)
    @JsonIgnore
    private String addressmail;
    @Column(length = 75)
    @JsonIgnore
    private String password;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "salle")
    private Set<Media> MediaList ;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "salle")
    private Set<Workout> WorkoutList ;
    @ManyToOne
    private Ville ville;
}
