package lines.module.sample;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SampleModuleConfiguration.class)
@EnableConfigurationProperties
public class SampleModuleConfiguration {
}
