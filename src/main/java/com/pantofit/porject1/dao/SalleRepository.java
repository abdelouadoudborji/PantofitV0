package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {

    Salle findByAddressmailAndPassword(String email,String password);
    Salle findByAddressmail(String email);
    Salle findByCode(String code);

}
