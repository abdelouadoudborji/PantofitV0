package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Abonnement;
import com.pantofit.porject1.entities.Client;
import com.pantofit.porject1.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    Abonnement findByClientAndCourant(Optional<Client> client , boolean courant);
    public final static String GET_LOAN_REPORTS = "UPDATE  Abonnement a SET a.courant=0  WHERE id = :id";
    @Query(GET_LOAN_REPORTS)
    Void abonnementexpirer(@Param("id") Long id);
}
