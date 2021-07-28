package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rajkumar Banala 22-Feb-2021
 *
 */

@RestController
public class JobInvokerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(JobInvokerController.class);

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("accountJob")
	Job accountKeeperJob;

	@RequestMapping("/run-batch-job")
	public String handle() throws Exception {
		LOG.debug("handle()");

		JobParameters jobParameters = new JobParametersBuilder().addString("source", "Spring Boot").toJobParameters();
		jobLauncher.run(accountKeeperJob, jobParameters);

		return "Batch job has been invoked";
	}

}
