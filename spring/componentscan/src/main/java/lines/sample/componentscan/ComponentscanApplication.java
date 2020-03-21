package lines.sample.componentscan;

import lines.sample.componentscan.repository.CodeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentscanApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CodeRepository codeRepository = (CodeRepository)context.getBean("codeRepository");

		System.out.println(codeRepository != null);
	}

}
