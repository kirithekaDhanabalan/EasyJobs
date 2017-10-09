package com.EasyJobs.EasyJobsbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EasyJobs.EasyJobsbd.dao.JobDAO;
import com.EasyJobs.EasyJobsbd.model.Job;

@RestController
public class JobController {
	@Autowired
	JobDAO jobService;
    //Save Job
	@RequestMapping(value = "/job", method = RequestMethod.POST)
	public ResponseEntity<String> createNewJob(@RequestBody Job job) {
		System.out.println("Creating New Job" + job.getJobId());
		jobService.saveJob(job);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	// Retrieve Single job
	@GetMapping(value = "/job/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Job> getJob(@PathVariable("id") int id) {
		System.out.println("Fetching Job With Id " + id);
		Job job = jobService.findById(id);
		if (job == null) {
			System.out.println("Job With Id " + id + " not found");
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
	}

	// Retrieve All Jobs
	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> listAllJobs() {
		List<Job> job = jobService.findAllJobs();
		return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
	}

	// Delete Job By Id
	@RequestMapping(value = "/job/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Job> deleteUser(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting job with id " + id);
		Job job = jobService.findById(id);
		if (job == null) 
		{
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}

		jobService.deleteJobById(id);
		return new ResponseEntity<Job>(HttpStatus.OK);
	}
}
