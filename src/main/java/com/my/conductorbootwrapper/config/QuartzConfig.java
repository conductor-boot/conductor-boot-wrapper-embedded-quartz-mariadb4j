package com.my.conductorbootwrapper.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.my.conductorbootwrapper.constants.AppConstants;
import com.my.conductorbootwrapper.dto.request.ScheduleConductorWorkflowExecutionRequest;
import com.my.conductorbootwrapper.jobs.ScheduleConductorWorkflowExecutionJob;

public class QuartzConfig {

	 public static JobDetail buildJobDetail(String uniqueIdentifier, ScheduleConductorWorkflowExecutionRequest scheduleConductorWorkflowExecutionRequest) {
	        

	        JobDataMap jobDataMap = new JobDataMap();

	        jobDataMap.put(AppConstants.JSON, scheduleConductorWorkflowExecutionRequest.getJson());
	        
	        return JobBuilder.newJob(ScheduleConductorWorkflowExecutionJob.class)
	                .withIdentity(uniqueIdentifier, AppConstants.JOB_IDENTIFIER_GROUP)
	                .withDescription(AppConstants.JOB_IDENTIFIER_GROUP_DESCRIPTION)
	                .usingJobData(jobDataMap)
	                .storeDurably()
	                .build();
	    }

	    public static Trigger buildJobTrigger(String startDate, String endDate, JobDetail jobDetail, String cronExpression) {
	       try {
		    	   Date endAt = new SimpleDateFormat(AppConstants.DATE_FORMAT).parse(endDate);
		    	   if(null!=startDate)
		           {
		           	Date startAt = new SimpleDateFormat(AppConstants.DATE_FORMAT).parse(startDate);
		
		               
		           	return TriggerBuilder.newTrigger()
		                       .forJob(jobDetail)
		                       .withIdentity(jobDetail.getKey().getName(), AppConstants.WORKFLOW_TRIGGERS)
		                       .startAt(startAt)
		                       .endAt(endAt)
		                       .withDescription(AppConstants.SEND_WORKFLOW_TRIGGER)
		                       .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
		                       .build();
		           }
		           else
		           {
		           	return TriggerBuilder.newTrigger()
		                       .forJob(jobDetail)
		                       .withIdentity(jobDetail.getKey().getName(), AppConstants.WORKFLOW_TRIGGERS)
		                       .startNow()
		                       .endAt(endAt)
		                       .withDescription(AppConstants.SEND_WORKFLOW_TRIGGER)
		                       .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
		                       .build();
		           }
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	    	   return TriggerBuilder.newTrigger()
	                   .forJob(jobDetail)
	                   .withIdentity(jobDetail.getKey().getName(), AppConstants.WORKFLOW_TRIGGERS)
	                   .withDescription(AppConstants.SEND_WORKFLOW_TRIGGER)
	                   .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
	                   .build();
	       }
	    }
}
