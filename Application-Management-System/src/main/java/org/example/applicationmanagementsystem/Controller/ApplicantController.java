package org.example.applicationmanagementsystem.Controller;

import org.example.applicationmanagementsystem.Model.Applicant;
import org.example.applicationmanagementsystem.Sevice.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.getAllApplicant();
    }
    @GetMapping("/{name}")
    public List<Applicant> getApplicantByName(@PathVariable String name){
        return applicantService.getApplicantByName(name);
    }

    @PostMapping
    public Applicant postApplicant(@RequestBody Applicant applicant){
        return applicantService.postApplicant(applicant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApplicant(@PathVariable Long id){
         applicantService.deleteapplicant(id);

    }

    @PutMapping("update/{id}")
    public Applicant updateApplicant(@PathVariable Long id, @RequestBody Applicant applicant){
        return applicantService.update(id, applicant);

    }

    @GetMapping("/page")
    public Iterable<Applicant> getPagination(@RequestParam int page, @RequestParam int size) {
        return applicantService.getPagination(page, size);
    }

//    @GetMapping("/name")
//    public List<Applicant> getApplicantByName(@RequestParam String name){
//        System.out.println(name);
//        return applicantService.getApplicantbyname(name);
//    }

}
