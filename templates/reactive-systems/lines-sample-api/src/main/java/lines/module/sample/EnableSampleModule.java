package lines.module.sample;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(SampleModuleConfiguration.class)
public @interface EnableSampleModule {
}
