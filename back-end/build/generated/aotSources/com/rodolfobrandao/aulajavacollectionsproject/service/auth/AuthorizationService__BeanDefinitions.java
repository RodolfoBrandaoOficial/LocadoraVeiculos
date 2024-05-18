package com.rodolfobrandao.aulajavacollectionsproject.service.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthorizationService}.
 */
@Generated
public class AuthorizationService__BeanDefinitions {
  /**
   * Get the bean definition for 'authorizationService'.
   */
  public static BeanDefinition getAuthorizationServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthorizationService.class);
    InstanceSupplier<AuthorizationService> instanceSupplier = InstanceSupplier.using(AuthorizationService::new);
    instanceSupplier = instanceSupplier.andThen(AuthorizationService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
