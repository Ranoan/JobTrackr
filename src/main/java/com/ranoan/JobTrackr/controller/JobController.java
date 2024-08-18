package com.ranoan.JobTrackr.controller;

import com.ranoan.JobTrackr.entity.JobEntity;
import com.ranoan.JobTrackr.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<JobEntity> getJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/job")
    public ResponseEntity<JobEntity> getJobById(@RequestParam Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
}
