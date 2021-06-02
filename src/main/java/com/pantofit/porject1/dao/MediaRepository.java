package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MediaRepository extends JpaRepository<Media,Long> {
    public final static String GET_LOAN_REPORTS = "SELECT media FROM Media media  WHERE salle_id = :id";
    @Query(GET_LOAN_REPORTS)
    List<Media> getbysalle(@Param("id")Long id);
}
