package com.ranoan.JobTrackr.controller;

import com.ranoan.JobTrackr.entity.JobEntity;
import com.ranoan.JobTrackr.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/get/jobs")
    public List<JobEntity> getJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/get/job/{jobId}")
    public ResponseEntity<JobEntity> getJobById(
            @PathVariable Long jobId) {
        return jobService.getJobById(jobId)
                .map(job -> ResponseEntity.ok(job))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/delete/job/{jobId}")
    public ResponseEntity<Void> insertJob(
            @PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }
}
