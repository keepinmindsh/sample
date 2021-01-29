package com.schedular.listner;

import com.schedular.job.QueryExecutor;
import com.wings.taskmanager.builder.CronTimerFullBuilder;
import com.wings.taskmanager.builder.TriggerSettingBuilder;
import com.wings.taskmanager.connector.TaskSchedulerConnector;
import com.wings.taskmanager.executor.TaskExecutor;
import com.wings.util.code.BuilderType;
import com.wings.util.code.ScheduleType;
import com.wings.util.executor.Executor;
import com.wings.util.provider.WINGSCommonProvider;
import com.wings.util.provider.WINGSScheduleProvider;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class BookingSchedularReadyListener {

	ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws Exception {

		WINGSScheduleProvider wingsScheduleProvider = new WINGSScheduleProvider();

		executorService.scheduleAtFixedRate(() -> {
			try{

				QueryExecutor queryExecutor = new QueryExecutor();

				log.info("Call Call");

			}catch (Exception ex){
				log.error(ex.getMessage());
			}
		}, 1,15, TimeUnit.SECONDS);
	}

	@PreDestroy
	public void destroy() throws Exception {

	}
}
