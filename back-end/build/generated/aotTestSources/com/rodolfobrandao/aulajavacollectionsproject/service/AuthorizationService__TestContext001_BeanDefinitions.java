package com.rodolfobrandao.aulajavacollectionsproject.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthorizationService}.
 */
@Generated
public class AuthorizationService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'authorizationService'.
   */
  public static BeanDefinition getAuthorizationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthorizationService.class);
    InstanceSupplier<AuthorizationService> instanceSupplier = InstanceSupplier.using(AuthorizationService::new);
    instanceSupplier = instanceSupplier.andThen(AuthorizationService__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
