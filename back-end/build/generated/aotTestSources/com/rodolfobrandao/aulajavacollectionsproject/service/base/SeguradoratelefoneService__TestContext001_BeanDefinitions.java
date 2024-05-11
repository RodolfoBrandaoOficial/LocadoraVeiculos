package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link SeguradoratelefoneService}.
 */
@Generated
public class SeguradoratelefoneService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'seguradoratelefoneService'.
   */
  private static BeanInstanceSupplier<SeguradoratelefoneService> getSeguradoratelefoneServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SeguradoratelefoneService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new SeguradoratelefoneService(args.get(0)));
  }

  /**
   * Get the bean definition for 'seguradoratelefoneService'.
   */
  public static BeanDefinition getSeguradoratelefoneServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SeguradoratelefoneService.class);
    beanDefinition.setInstanceSupplier(getSeguradoratelefoneServiceInstanceSupplier());
    return beanDefinition;
  }
}
