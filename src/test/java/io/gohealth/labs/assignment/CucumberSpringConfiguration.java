package io.gohealth.labs.assignment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootTest
public class CucumberSpringConfiguration implements ApplicationContextAware {
  private static ApplicationContext applicationContext;

  @Autowired
  public CucumberSpringConfiguration(ApplicationContext applicationContext) {
    CucumberSpringConfiguration.applicationContext = applicationContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    CucumberSpringConfiguration.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return CucumberSpringConfiguration.applicationContext;
  }
}
