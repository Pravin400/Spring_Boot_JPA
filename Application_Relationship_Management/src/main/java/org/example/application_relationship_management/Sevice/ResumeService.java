package org.example.application_relationship_management.Sevice;

import lombok.AllArgsConstructor;
import org.example.application_relationship_management.Dao.ApplicantDao;
import org.example.application_relationship_management.Dao.ApplicantJpaDao;
import org.example.application_relationship_management.Dao.ResumeDao;
import org.example.application_relationship_management.Model.Applicant;
import org.example.application_relationship_management.Model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ResumeService {

    @Autowired
    ResumeDao resumeDao;

    @Autowired
    ApplicantJpaDao applicantJpaDao;

    public Resume addResume(Long id, @RequestBody Resume resume) {

        Optional<Applicant> applicant = applicantJpaDao.findById(id);
        if (applicant.isPresent()) {

                Applicant applican = applicant.get();
                resume.setApplicant(applican);
                return  resumeDao.save(resume);
//            resume.setApplicant(applicant.get());
//            resumeDao.save(resume);
//            return resume;
        }
        else {
            throw new RuntimeException("Applicant not found with id " + id );
        }
    }

    public Resume getResume(Long id){
        return resumeDao.findByApplicant_Id(id);
    }

    public List<Resume> getAllresume() {
        return resumeDao.findAll();
    }
}
