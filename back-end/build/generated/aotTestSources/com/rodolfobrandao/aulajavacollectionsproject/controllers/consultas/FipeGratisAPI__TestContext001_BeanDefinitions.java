package com.rodolfobrandao.aulajavacollectionsproject.controllers.consultas;

import java.lang.SuppressWarnings;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link FipeGratisAPI}.
 */
@Generated
public class FipeGratisAPI__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'fipeGratisAPI'.
   */
  @SuppressWarnings("deprecation")
  public static BeanDefinition getFipeGratisAPIBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FipeGratisAPI.class);
    beanDefinition.setTargetType(FipeGratisAPI.class);
    ConfigurationClassUtils.initializeConfigurationClass(FipeGratisAPI.class);
    beanDefinition.setInstanceSupplier(FipeGratisAPI$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
