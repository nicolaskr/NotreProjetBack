package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import notreProjetBack.AppSpringThibault;
import notreProjetBack.config.AppConfig;

public class AppTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBeanFactory().createBean(AppSpringThibault.class).run(args);
		ctx.close();
	}

}
