package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
    public final static String GET_LOAN_REPORTS = "SELECT salle FROM Salle salle  WHERE id = :id";
    Salle findByAddressmailAndPassword(String email,String password);
    @Query(GET_LOAN_REPORTS)
Salle getsalle(@Param("id") Long id);

}
