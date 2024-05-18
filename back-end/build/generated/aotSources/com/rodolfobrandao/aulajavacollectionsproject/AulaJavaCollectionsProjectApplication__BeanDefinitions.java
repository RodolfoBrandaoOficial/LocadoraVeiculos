package com.rodolfobrandao.aulajavacollectionsproject;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link AulaJavaCollectionsProjectApplication}.
 */
@Generated
public class AulaJavaCollectionsProjectApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'aulaJavaCollectionsProjectApplication'.
   */
  public static BeanDefinition getAulaJavaCollectionsProjectApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AulaJavaCollectionsProjectApplication.class);
    beanDefinition.setTargetType(AulaJavaCollectionsProjectApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(AulaJavaCollectionsProjectApplication.class);
    beanDefinition.setInstanceSupplier(AulaJavaCollectionsProjectApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
