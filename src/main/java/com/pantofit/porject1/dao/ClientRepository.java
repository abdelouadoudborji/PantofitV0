package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Client;
import com.pantofit.porject1.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByAddressmailAndPassword(String email, String password);
    Client findByAddressmail(String email);
}
