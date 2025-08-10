package org.example.application_relationship_management.Dao;

import org.example.application_relationship_management.Model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeDao extends JpaRepository<Resume,Long> {

    Resume findByApplicant_Id(Long id);
}
