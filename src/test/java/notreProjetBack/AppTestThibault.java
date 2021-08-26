package notreProjetBack;

import notreProjetBack.AppSpringThibault;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import notreProjetBack.config.AppConfig;

public class AppTestThibault {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.getBeanFactory().createBean(AppSpringThibault.class).run(args);
        ctx.close();
    }

}
