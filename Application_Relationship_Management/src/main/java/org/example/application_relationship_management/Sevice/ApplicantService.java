package org.example.application_relationship_management.Sevice;

import lombok.AllArgsConstructor;
import org.example.application_relationship_management.Dao.ApplicantDao;
import org.example.application_relationship_management.Dao.ApplicantJpaDao;
import org.example.application_relationship_management.Dao.ApplicantPaginationDao;
import org.example.application_relationship_management.Model.Applicant;
import org.example.application_relationship_management.Model.Application;
import org.example.application_relationship_management.Model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicantService {

    @Autowired
    private ApplicantDao applicantDao;

    @Autowired
    private ApplicantPaginationDao paginationDao;

    @Autowired
    private ApplicantJpaDao applicantJpaDao;
    public Applicant postApplicant(@RequestBody Applicant applicant){
        Resume resume=applicant.getResume();
        List<Application> application = applicant.getApplications();
        if(resume!=null){
            resume.setApplicant(applicant);
        }
        if(application!=null){
            for(Application app:application){
//now here set application to each of the applicant
                app.setApplicant(applicant);
            }

        }
        return applicantDao.save(applicant);
    }

    public List<Applicant> getAllApplicant() {
        //in application service findall can return the Iterable so we need to convert it in to iterable to array

        Iterable<Applicant> applicants = applicantJpaDao.findAll();
        List<Applicant> applicantList = new ArrayList<>();
//        applicants.forEach(applicant -> applicantList.add(applicant));
        applicants.forEach(applicantList :: add);
//        for (Applicant applicant : applicants) {
//            applicantList.add(applicant);
//        }
        return applicantList;
    }
    public List<Applicant> getApplicantByName(String name){
        return applicantJpaDao.findByNameLike(name);
    }
    public void deleteapplicant(Long id) {
        applicantDao.deleteById(id);
    }

    public Applicant update(Long id, Applicant updatedApplicant) {
        Applicant existingApplicant = applicantDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + id));

        // Copy updated fields
        existingApplicant.setName(updatedApplicant.getName());
        existingApplicant.setEmail(updatedApplicant.getEmail());
        existingApplicant.setPhone(updatedApplicant.getPhone());
        // ... any other fields

        return applicantDao.save(existingApplicant);
    }

//    public List<Applicant> getApplicantyname(String applicantname) {
//        return applicantJpaDao.findBynameOrderByEmailAsc(applicantname);
//
//    }

    public  Iterable<Applicant> getPagination(int page, int size) {
        return paginationDao.findAll(PageRequest.of(page, size));
    }
}
