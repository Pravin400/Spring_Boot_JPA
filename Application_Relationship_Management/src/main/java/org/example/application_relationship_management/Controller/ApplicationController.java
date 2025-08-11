package org.example.application_relationship_management.Controller;

import org.example.application_relationship_management.Model.Application;
import org.example.application_relationship_management.Sevice.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
@PostMapping("/{id}")
    private ResponseEntity<Application> createApplication(@PathVariable Long id, @RequestBody Application application){
    return ResponseEntity.ok(applicationService.createApplication(id,application));
}
}
