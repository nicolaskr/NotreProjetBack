package notreProjetBack;

import notreProjetBack.AppSpringNico;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import notreProjetBack.config.AppConfig;

public class AppTestNico {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.getBeanFactory().createBean(AppSpringNico.class).run(args);
        ctx.close();
    }

}
