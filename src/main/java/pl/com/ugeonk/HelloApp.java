package pl.com.ugeonk;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.ugeonk.service.DebuggingService;
import pl.com.ugeonk.service.PrototypeService;

import java.util.Arrays;

public class HelloApp {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
        printSpringContextBeans(context);

        DebuggingService debuggingService =context.getBean(DebuggingService.class);
        debuggingService.testAllDebugLevel();

        context.getBean(PrototypeService.class);

        //call predestroy methods
        context.registerShutdownHook();
    }

    private static void printSpringContextBeans(AbstractApplicationContext context) {
        System.out.println("Beans names:");
        Arrays.stream(context.getBeanDefinitionNames())
                .filter(n -> !n.contains("springframework"))
                .forEach(System.out::println);

        long noSpringBeansCount = Arrays.stream(context.getBeanDefinitionNames())
                .filter(n -> !n.contains("springframework")).count();

        System.out.println("Beans count: " + noSpringBeansCount);
    }
}
