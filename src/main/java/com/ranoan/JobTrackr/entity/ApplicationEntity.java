package com.ranoan.JobTrackr.entity;

import com.ranoan.JobTrackr.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Applications")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String dateApplied;
    @OneToOne
    @JoinColumn(name = "job_id", nullable = false, unique = true)
    private JobEntity job;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String jobSite;
    private String resumeVersion;
}
