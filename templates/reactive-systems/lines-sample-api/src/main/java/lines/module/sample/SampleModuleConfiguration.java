package lines.module.sample;

import lines.module.sample.context.beans.PublishedComponentRegisteringPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SampleModuleConfiguration.class)
@EnableConfigurationProperties
public class SampleModuleConfiguration {

//    @Bean
//    public PublishedComponentRegisteringPostProcessor ideaPublishedComponentRegisteringPostProcessor(ConfigurableListableBeanFactory beanFactory) {
//        return new PublishedComponentRegisteringPostProcessor(beanFactory);
//    }
}
