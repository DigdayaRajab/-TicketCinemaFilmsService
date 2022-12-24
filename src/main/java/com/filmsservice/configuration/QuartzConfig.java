package com.filmsservice.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
////import org.quartz.spi.JobFactory;
//import org.example.scheduler.FirstScheduler;
//import org.quartz.JobDetail;
//import org.quartz.Trigger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.*;

@Slf4j
@Configuration
public class QuartzConfig {
//
//    private final ApplicationContext ctx;
//
//    @Autowired
//    public QuartzScheduler(ApplicationContext ctx) {
//        this.ctx = ctx;
//    }
//
//    @Bean
//    public SpringBeanJobFactory springBeanJobFactory() {
//        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
//        jobFactory.setApplicationContext(ctx);
//        return jobFactory;
//    }
//
//    @Bean
//    public SchedulerFactoryBean scheduler() {
//        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
//        schedulerFactory.setJobFactory(springBeanJobFactory());
//        JobDetail[] jobs = {
//                job1().getObject()
//        };
//        Trigger[] triggers = {
//                trigger1().getObject()
//        };
//        schedulerFactory.setJobDetails(jobs);
//        schedulerFactory.setTriggers(triggers);
//        return schedulerFactory;
//    }
//
//    @Bean
//    public JobDetailFactoryBean job1() {
//        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
//        jobDetailFactoryBean.setJobClass(FirstScheduler.class);
//        jobDetailFactoryBean.setName("Test job 1");
//        jobDetailFactoryBean.setDescription("description 1");
//        jobDetailFactoryBean.setDurability(true);
//        return jobDetailFactoryBean;
//    }
//
//    @Bean
//    public CronTriggerFactoryBean trigger1() {
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(job1().getObject());
//        trigger.setName("trigger 1");
//        trigger.setCronExpression("* * * * * ? *");
//        return trigger;
//    }
}
