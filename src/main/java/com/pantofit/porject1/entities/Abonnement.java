package com.pantofit.porject1.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor @ToString @AllArgsConstructor
@Data
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String Code="E256E";
    @ManyToOne
    private Plan plan;
    private int nbrseancerestants;
    private boolean courant;
    @ManyToOne
    private Client client;
    private String qrcode;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "abonnement")
    private List<Workout> WorkoutList ;



}



