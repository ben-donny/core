package pl.com.ugeonk.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Mateusz Nowakowski, Capgemini Technology Services.
 */
@Service
@Scope("prototype")
public class PrototypeService {

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Init method after properties are set for class: " + this.getClass().getSimpleName() );
        System.out.println("-----------------------------------------------------------");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up: " + this.getClass().getSimpleName());
    }
}