package org.example.application_relationship_management.Dao;

import org.example.application_relationship_management.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaDao extends JpaRepository<Applicant,Long> {


//    List<Applicant> findBynameOrderByEmailAsc(String name);

//    List<Applicant> findALLOrderByName(String name);
    @Query("SELECT a FROM Applicant a WHERE a.name Like %:name%")
    List<Applicant> findByNameLike(@Param("name") String name);

}
