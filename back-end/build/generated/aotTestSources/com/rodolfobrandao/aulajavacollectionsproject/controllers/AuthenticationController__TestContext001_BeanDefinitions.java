package com.rodolfobrandao.aulajavacollectionsproject.controllers;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthenticationController}.
 */
@Generated
public class AuthenticationController__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'authenticationController'.
   */
  public static BeanDefinition getAuthenticationControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationController.class);
    InstanceSupplier<AuthenticationController> instanceSupplier = InstanceSupplier.using(AuthenticationController::new);
    instanceSupplier = instanceSupplier.andThen(AuthenticationController__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
