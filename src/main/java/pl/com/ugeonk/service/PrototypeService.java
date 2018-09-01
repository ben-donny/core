package pl.com.ugeonk.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

  private static final Logger LOGGER = LogManager.getLogger(PrototypeService.class);

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