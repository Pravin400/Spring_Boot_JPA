package org.example.application_relationship_management.Controller;

import org.example.application_relationship_management.Model.Resume;
import org.example.application_relationship_management.Sevice.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @PostMapping("/{applicantId}/resume")
    public ResponseEntity<Resume> addResume(@PathVariable Long applicantId,@RequestBody Resume resume){
        return ResponseEntity.ok(resumeService.addResume(applicantId,resume));
    }

    @GetMapping("/{id}/resume")
    public ResponseEntity<Resume> getResume(@PathVariable Long id){
        return ResponseEntity.ok(resumeService.getResume(id));
    }

    @GetMapping("/allResume")
    public ResponseEntity<List<Resume>> getAllResume(){
        return ResponseEntity.ok(resumeService.getAllresume());
    }



}
