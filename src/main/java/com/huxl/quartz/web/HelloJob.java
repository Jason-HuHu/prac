package com.huxl.quartz.web;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
//@DisallowConcurrentExecution
public class HelloJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail();
		String name = detail.getJobDataMap().getString("name");
		System.out.println("say hello to " + name + " at " + new Date());

		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("say hello to " + name + " at " + new Date() + " ��end  !!!!");*/

	}
}