package com.pantofit.porject1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Media {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long visible;
    @Column(length = 75)
    private String Code;
    @Column(length = 75)
    private String path;

  /*  @ManyToOne
    private Salle salle;*/
}

