package org.example.application_relationship_management.Dao;

import org.example.application_relationship_management.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicationJpaDao extends JpaRepository<Application,Long> {

}
