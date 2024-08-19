import { Job } from "./Job";

export interface Application {
    dateApplied: Date | null;
    job: Job;
    status: string;
    jobSite: string;
    resumeVersion: string;
}