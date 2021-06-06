package com.pantofit.porject1.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Media {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long visible;
    @Column(length = 75)
    private String Code;
    @Column(length = 1000000000)
    private byte[] picbyte;
    @ManyToOne
    private Salle salle;
}

