package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author huxl
 * @createDate 2017/12/14 15:04
 */
public class TestQuartz {
    public static void main(String[] args) {
        try {

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            //动态加载一个类
//            Class clazz = Class.forName("");
            //定义一个jobDetail 并引用Job接口的实现类
            JobDetail jobDetail = newJob(MyJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("name","quanquan ")
                    .build();
            //定义一个Trigger，并设置任务时间
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(2)  //每秒钟执行一次
                            .repeatForever())                         //重复执行
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);

            Thread.sleep(1000 * 10 );
            System.out.println("结束了！");
//            scheduler.shutdown(true);

            /*********暂停一个任务************/

            scheduler.pauseJob(jobDetail.getKey());
            System.out.println("该任务已暂停");
            Thread.sleep(5000);
            scheduler.resumeJob(jobDetail.getKey());
            System.out.println("该任务已重启");

        }catch (Exception e) {

        }
    }

}
