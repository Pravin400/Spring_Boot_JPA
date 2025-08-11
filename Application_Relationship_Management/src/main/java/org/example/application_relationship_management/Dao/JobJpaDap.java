package org.example.application_relationship_management.Dao;

import org.example.application_relationship_management.Model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobJpaDap extends JpaRepository<Jobs,Long> {
}
