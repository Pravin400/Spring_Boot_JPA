package org.example.applicationmanagementsystem.Dao;

import org.example.applicationmanagementsystem.Model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
//first parameter is entity and 2nd parameter is data type of primary key
public interface ApplicantPaginationDao extends PagingAndSortingRepository<Applicant,Long> {
}
