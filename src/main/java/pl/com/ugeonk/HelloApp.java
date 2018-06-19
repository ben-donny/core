package pl.com.ugeonk;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.ugeonk.service.PrototypeService;

public class HelloApp {

    private static final Logger logger = LogManager.getLogger(HelloApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
        String[] beans = context.getBeanDefinitionNames();
        logger.info("Beans names:");
        for(String beanName: beans){
            logger.debug(beanName);
        }
        logger.warn("Beans count: " + context.getBeanDefinitionCount());

        //logger.error("error");
        //logger.fatal("fatal");
        context.getBean(PrototypeService.class);
    }

}
