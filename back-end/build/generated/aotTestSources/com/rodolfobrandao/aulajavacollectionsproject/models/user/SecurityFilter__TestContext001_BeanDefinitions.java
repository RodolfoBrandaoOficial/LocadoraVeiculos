package com.rodolfobrandao.aulajavacollectionsproject.models.user;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SecurityFilter}.
 */
@Generated
public class SecurityFilter__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'securityFilter'.
   */
  public static BeanDefinition getSecurityFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilter.class);
    InstanceSupplier<SecurityFilter> instanceSupplier = InstanceSupplier.using(SecurityFilter::new);
    instanceSupplier = instanceSupplier.andThen(SecurityFilter__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
