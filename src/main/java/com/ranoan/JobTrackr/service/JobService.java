package com.ranoan.JobTrackr.service;

import com.ranoan.JobTrackr.entity.JobEntity;
import com.ranoan.JobTrackr.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> getAllJobs() {
        return jobRepository.findAll();
    }

    public JobEntity getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public JobEntity insertJob(JobEntity job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
