package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Salle;
import com.pantofit.porject1.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
}
