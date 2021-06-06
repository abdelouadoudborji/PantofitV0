package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Media;
import com.pantofit.porject1.entities.Salle;
import com.pantofit.porject1.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    public final static String GET_LOAN_REPORTS = "SELECT workout FROM Workout workout  WHERE salle_id = :id";
    @Query(GET_LOAN_REPORTS)
    List<Workout> getbysalle(@Param("id")Long id);
}
