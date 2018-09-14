package ru.mzainullin.testsql.jobparser;

import org.quartz.Trigger;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;

/**
 * @author Marat Zainullin
 * @since 14.06.2018
 */
public class CronTrigger {

    public CronTrigger(Trigger trigger) {
        trigger = newTrigger()
                .withIdentity("http://www.sql.ru/forum/job", "status")
                .withSchedule(cronSchedule("0 0/2 8-17 * * ?"))
                .forJob("workers", "status")
                .build();
    }

}
