package com.example.demo.config.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：zhaoyu
 * @date ：Created in 2019/2/20 9:26
 */

@Configuration
@EnableScheduling
@Component
public class SchedulerExample {



    @Scheduled(fixedRate = 1000) // 每隔1s执行一次
    public void scheduleUpdateCronTrigger2() throws SchedulerException {
//        System.out.println("scheduleUpdateCronTrigger");
    }


    //对于一般的定时任务, 直接使用schedule即可
    @Scheduled(fixedRate = 1000)
    public void test(){
//        System.out.println("test");
    }




    @Resource(name = "jobDetail")
    private JobDetail jobDetail;

    @Resource(name = "jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name = "scheduler")
    private Scheduler scheduler;


    @Scheduled(fixedRate = 5000) // 每隔5s查库，并根据查询结果决定是否重新设置定时任务
    public void scheduleUpdateCronTrigger() throws SchedulerException {
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        String currentCron = trigger.getCronExpression();// 当前Trigger使用的
        String searchCron = "0/5 * * * * ?";// 从数据库查询出来的
//        System.out.println(currentCron);
//        System.out.println(searchCron);
        if (currentCron.equals(searchCron)) {
            // 如果当前使用的cron表达式和从数据库中查询出来的cron表达式一致，则不刷新任务
        } else {
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
            // 按新的cronExpression表达式重新构建trigger
            trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
                    .withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
            currentCron = searchCron;
        }
    }

}
