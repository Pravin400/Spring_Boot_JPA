package org.example.applicationmanagementsystem.Sevice;

import lombok.AllArgsConstructor;
import org.example.applicationmanagementsystem.Dao.ApplicantDao;
import org.example.applicationmanagementsystem.Dao.ApplicantJpaDao;
import org.example.applicationmanagementsystem.Dao.ApplicantPaginationDao;
import org.example.applicationmanagementsystem.Model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

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
