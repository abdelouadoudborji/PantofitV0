package com.pantofit.porject1.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String Code;
    @Column(length = 75)
    private String name;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ville")
    private Set<Salle> SalleList ;
}
