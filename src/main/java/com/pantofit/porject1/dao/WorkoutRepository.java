package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Salle;
import com.pantofit.porject1.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
public interface WorkoutRepository extends JpaRepository<Workout,Long> {
}
