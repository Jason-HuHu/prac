package com.huxl.quartz;

import org.quartz.*;

import java.util.Date;

/**
 * @author huxl
 * @createDate 2017/12/14 15:03
 * JobDetail是任务的定义，Job是任务执行逻辑
 * 在Jobdetail中会引用一个Job 的实现类
 */
//@DisallowConcurrentExecution
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String name = (String) jobDetail.getJobDataMap().get("name");
        System.out.println(new Date() + "---:Helo Quartz,MyJob is excuting!" + name);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
