package com.pantofit.porject1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @ToString
@Data
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String Code;
    @Column(length = 75)
    private String NomComplet;
    @Column(length = 75)
    private String tel;
    @Column(length = 75)
    private String addressmail;
    @Column(length = 75)
    private String password;
    private Date date_naissance;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "client")
    private List<Abonnement> AbonnementList ;


    public Client(String email,String password){
        this.addressmail=email;
        this.password=password;
    }

}
