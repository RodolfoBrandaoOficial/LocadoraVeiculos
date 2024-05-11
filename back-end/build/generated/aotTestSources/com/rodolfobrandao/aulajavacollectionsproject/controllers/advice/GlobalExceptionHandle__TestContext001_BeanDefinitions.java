package com.rodolfobrandao.aulajavacollectionsproject.controllers.advice;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link GlobalExceptionHandle}.
 */
@Generated
public class GlobalExceptionHandle__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'globalExceptionHandle'.
   */
  public static BeanDefinition getGlobalExceptionHandleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GlobalExceptionHandle.class);
    beanDefinition.setInstanceSupplier(GlobalExceptionHandle::new);
    return beanDefinition;
  }
}
