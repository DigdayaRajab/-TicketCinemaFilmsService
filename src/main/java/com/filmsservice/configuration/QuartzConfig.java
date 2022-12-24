package com.filmsservice.configuration;

import com.filmsservice.schedulers.resetFilmStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.*;

@Slf4j
@Configuration
public class QuartzConfig {

    private final ApplicationContext ctx;

    @Autowired
    public QuartzConfig(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(ctx);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean scheduler() {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setJobFactory(springBeanJobFactory());
        JobDetail[] jobs = {
                job1().getObject()
        };
        Trigger[] triggers = {
                trigger1().getObject()
        };
        schedulerFactory.setJobDetails(jobs);
        schedulerFactory.setTriggers(triggers);
        return schedulerFactory;
    }

    @Bean
    public JobDetailFactoryBean job1() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(resetFilmStatus.class);
        jobDetailFactoryBean.setName("Reset Job");
        jobDetailFactoryBean.setDescription("Reset Film Show Status to false");
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean trigger1() {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(job1().getObject());
        trigger.setName("Trigger 1");
        trigger.setCronExpression("0 40 23 * * ? *");
        return trigger;
    }
}
