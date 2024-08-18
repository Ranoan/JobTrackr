package com.ranoan.JobTrackr.controller;

import com.ranoan.JobTrackr.entity.ApplicationEntity;
import com.ranoan.JobTrackr.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/get/applications")
    public List<ApplicationEntity> getApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/get/application/{appId}")
    public ResponseEntity<ApplicationEntity> getApplicationById(
            @PathVariable Long appId) {
        return applicationService.getApplicationById(appId)
                .map(app -> ResponseEntity.ok(app))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping("/add/application")
    public ResponseEntity<ApplicationEntity> addApplication(
            @RequestBody ApplicationEntity applicationEntity) {
        return ResponseEntity.ok(applicationService.insertApplication(applicationEntity));
    }

    @PutMapping("/update/application/{appId}")
    public ResponseEntity<ApplicationEntity> updateApplicationById(
            @PathVariable Long appId,
            @RequestBody ApplicationEntity applicationEntity) {
        return ResponseEntity.ok(applicationService.updateApplicationById(appId, applicationEntity));
    }

    @DeleteMapping("/delete/application/{appId}")
    public ResponseEntity<Void> deleteApplicationById(
            @PathVariable Long appId) {
        applicationService.deleteApplicationById(appId);
        return ResponseEntity.noContent().build();
    }
}
