package pl.com.ugeonk.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class HelloService {

  private static final Logger LOGGER = LogManager.getLogger(HelloService.class);

  public String sayHello() {
    return "Hello world!";
  }

  @PostConstruct
  public void initIt() throws Exception {
    LOGGER.info("-----------------------------------------------------------");
    LOGGER.info("Init method after properties are set for class: " + this.getClass().getSimpleName());
    LOGGER.info("-----------------------------------------------------------");
  }

  @PreDestroy
  public void cleanUp() throws Exception {
    LOGGER.info("Spring Container is destroy! Customer clean up: " + this.getClass().getSimpleName());
  }

}
