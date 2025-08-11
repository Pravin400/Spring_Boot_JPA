package org.example.application_relationship_management.Sevice;

import org.example.application_relationship_management.Dao.ApplicantJpaDao;
import org.example.application_relationship_management.Dao.JobJpaDap;
import org.example.application_relationship_management.Model.Applicant;
import org.example.application_relationship_management.Model.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobJpaDap jobJpaDap;

    @Autowired
    ApplicantJpaDao applicantJpaDao;

    public Jobs postJob(Jobs job) {
        return jobJpaDap.save(job);
    }

    public Applicant addApplicantToJob(Long jobId,Long applicantId) {
        Optional<Applicant> applicant = applicantJpaDao.findById(applicantId);
        Optional<Jobs> jobs = jobJpaDap.findById(jobId);
        if(applicant.isPresent() && jobs.isPresent()) {
            applicant.get().getJobs().add(jobs.get());
            applicantJpaDao.save(applicant.get());
            return applicant.get();
        }
        else {
            throw new IllegalArgumentException("Job id or Applicant id not found");
        }
    }

    public List<Jobs> getJobs() {
        return jobJpaDap.findAll();
    }

    public Jobs getJobById(Long jobId) {
        return jobJpaDap.findById(jobId).get();
    }


}
