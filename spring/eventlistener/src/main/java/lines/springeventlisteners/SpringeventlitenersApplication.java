package lines.springeventlisteners;

import lines.springeventlisteners.beans.EventHolderBean;
import lines.springeventlisteners.command.impl.PrintCommand;
import lines.springeventlisteners.eventpublisher.CustomSpringEventPublisher;
import lines.springeventlisteners.eventpublisher.GenericCustomSpringEventPublisher;
import lines.springeventlisteners.lifecycle.LifeCycle;
import lines.springeventlisteners.listeners.ExitEventListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringeventlitenersApplication{

	@Bean
	ExitEventListener demoListenerBean() {
		return new ExitEventListener();
	}

	@Bean
	CommandLineRunner createException() {
		return args -> Integer.parseInt("20") ;
	}

	@Bean
	ExitCodeExceptionMapper exitCodeToexceptionMapper() {
		return exception -> { // set exit code base on the exception type
			 if (exception.getCause() instanceof NumberFormatException) {
			 	return 22;
			 }
			 return 1;
		};
	}

	@Bean(destroyMethod = "destroy")
	public LifeCycle lifeCycle(){
		return new LifeCycle();
	}

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringeventlitenersApplication.class, args);

		EventHolderBean bean = configurableApplicationContext.getBean(EventHolderBean.class);

		System.out.println("Event Processed ?! " + bean.getEventFired());

		CustomSpringEventPublisher customSpringEventPublisher = configurableApplicationContext.getBean(CustomSpringEventPublisher.class);

		customSpringEventPublisher.doStuffAndPublishAnEvent("이벤트 실행!");

		GenericCustomSpringEventPublisher genericSpringEventPublisher = configurableApplicationContext.getBean(GenericCustomSpringEventPublisher.class);

		genericSpringEventPublisher.doStuffAndPublishAnEvent(new PrintCommand(), true);

	}

}
