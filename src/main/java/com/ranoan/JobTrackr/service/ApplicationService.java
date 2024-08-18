package com.ranoan.JobTrackr.service;

import com.ranoan.JobTrackr.entity.ApplicationEntity;
import com.ranoan.JobTrackr.entity.JobEntity;
import com.ranoan.JobTrackr.repository.ApplicationRepository;
import com.ranoan.JobTrackr.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private JobRepository jobRepository;

    public List<ApplicationEntity> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<ApplicationEntity> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    public ApplicationEntity insertApplication(ApplicationEntity entity) {
        jobRepository.save(entity.getJob());
        return applicationRepository.save(entity);
    }

    public ApplicationEntity updateApplicationById(Long id, ApplicationEntity entity) {
        ApplicationEntity applicationEntity = getApplicationById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        JobEntity jobEntity = jobRepository.findById(applicationEntity.getJob().getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        jobRepository.save(jobEntity);
        applicationEntity.setJob(entity.getJob());
        applicationEntity.setStatus(entity.getStatus());
        applicationEntity.setJobSite(entity.getJobSite());
        applicationEntity.setDateApplied(entity.getDateApplied());
        applicationEntity.setResumeVersion(entity.getResumeVersion());
        return applicationRepository.save(applicationEntity);
    }

    public void deleteApplicationById(Long id) {
        applicationRepository.deleteById(id);
    }
}
