package com.pantofit.porject1.dao;

import com.pantofit.porject1.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlanRepository extends JpaRepository<Plan,Long> {
}
