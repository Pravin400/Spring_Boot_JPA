package org.example.application_relationship_management.Controller;

import org.example.application_relationship_management.Model.Applicant;
import org.example.application_relationship_management.Model.Jobs;
import org.example.application_relationship_management.Sevice.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
  public ResponseEntity<Jobs> addJob(@RequestBody Jobs jobs) {
        System.out.println(jobs.toString());
      return  ResponseEntity.ok(jobService.postJob(jobs));
  }

  @GetMapping("/{jobId}")
  public ResponseEntity<Jobs> getJobById(@PathVariable Long jobId) {
      return ResponseEntity.ok(jobService.getJobById(jobId));
  }

  @GetMapping
  public ResponseEntity<List<Jobs>> getAllJobs() {
        return ResponseEntity.ok((jobService.getJobs()));
  }

  @PostMapping("/{jobId}/applicant/{appId}")
    public ResponseEntity<Applicant> addJobToApplicant(@PathVariable Long jobId, @PathVariable Long appId) {
        Applicant updateApplicant = jobService.addApplicantToJob(jobId, appId);
        return ResponseEntity.ok(updateApplicant);
  }

}
