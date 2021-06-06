package com.pantofit.porject1.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Workout {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Abonnement abonnement;
    @ManyToOne
    private Salle salle;
    private Date date_workout;


}
