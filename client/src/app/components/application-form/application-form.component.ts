import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Application } from 'src/app/model/Application';
import { Job } from 'src/app/model/Job';

@Component({
  selector: 'app-application-form',
  templateUrl: './application-form.component.html',
  styleUrls: ['./application-form.component.css']
})
export class ApplicationFormComponent {
  

  job: Job = {
    title: '',
    company: '',
    location: '',
    salary: 0
  };
  
  application: Application = {
    dateApplied: null,
    job: this.job,
    status: '',
    jobSite: '',
    resumeVersion: ''
  };


  // applications: Application[] = [
  //   {
  //     "job": {
  //       title: "Engineer",
  //       company: "Cap",
  //       location: "New york",
  //       salary: 1230
  //     },
  //     dateApplied: null,
  //     status: '',
  //     jobSite: '',
  //     resumeVersion: ''
  //   }
  // ];

  applications = new MatTableDataSource<Application>([]);

  displayedColumns: string[] = ['title', 'company', 'location', 'salary', 'status', 'dateApplied'];

  onSubmit() {
    const newApplication = { ...this.application };

    // Push the new application to the data array
    const currentData = this.applications.data;
    this.applications.data = [...currentData, newApplication]; // Assign a new array

    // Reset the form
    this.job = {
      title: '',
      company: '',
      location: '',
      salary: 0
    }
    this.application = {
      dateApplied: null,
      job: this.job,
      status: '',
      jobSite: '',
      resumeVersion: ''
    };
  }
}

