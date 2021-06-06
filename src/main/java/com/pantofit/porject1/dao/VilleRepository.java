package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville,Long> {
}
