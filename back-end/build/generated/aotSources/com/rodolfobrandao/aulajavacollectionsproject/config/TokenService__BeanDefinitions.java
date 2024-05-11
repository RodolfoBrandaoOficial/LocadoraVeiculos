package com.rodolfobrandao.aulajavacollectionsproject.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TokenService}.
 */
@Generated
public class TokenService__BeanDefinitions {
  /**
   * Get the bean definition for 'tokenService'.
   */
  public static BeanDefinition getTokenServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TokenService.class);
    InstanceSupplier<TokenService> instanceSupplier = InstanceSupplier.using(TokenService::new);
    instanceSupplier = instanceSupplier.andThen(TokenService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
