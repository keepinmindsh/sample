package lines.module.sample.context.beans;


import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Published {
}
