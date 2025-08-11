package org.example.application_relationship_management.Sevice;

import lombok.AllArgsConstructor;
import org.example.application_relationship_management.Dao.ApplicantDao;
import org.example.application_relationship_management.Dao.ApplicantJpaDao;
import org.example.application_relationship_management.Dao.ApplicationJpaDao;
import org.example.application_relationship_management.Model.Applicant;
import org.example.application_relationship_management.Model.Application;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ApplicationService {

    @Autowired
    private ApplicationJpaDao applicationJpaDao;
    @Autowired
    private ApplicantJpaDao applicantJpaDao;


    public Application createApplication(Long id,Application application) {
        Optional<Applicant> applicant = applicantJpaDao.findById(id);
        if(applicant.isPresent()) {
            Applicant applicant1 = applicant.get();
            application.setApplicant(applicant1);
            return applicationJpaDao.save(application);
        }
        else {
            throw new RuntimeException("Applicant Not Found With Id: " + id);
        }

       }
}
