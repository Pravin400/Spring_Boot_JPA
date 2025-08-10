package org.example.application_relationship_management.Dao;

import org.example.application_relationship_management.Model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
//first parameter is entity and 2nd parameter is data type of primary key
public interface ApplicantDao extends CrudRepository<Applicant,Long> {
}
