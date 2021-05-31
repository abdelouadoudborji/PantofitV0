package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
    Salle findByAddressmailAndPassword(String email,String password);
}
