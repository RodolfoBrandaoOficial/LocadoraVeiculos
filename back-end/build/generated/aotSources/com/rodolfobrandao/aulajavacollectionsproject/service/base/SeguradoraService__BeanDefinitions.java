package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link SeguradoraService}.
 */
@Generated
public class SeguradoraService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'seguradoraService'.
   */
  private static BeanInstanceSupplier<SeguradoraService> getSeguradoraServiceInstanceSupplier() {
    return BeanInstanceSupplier.<SeguradoraService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new SeguradoraService(args.get(0)));
  }

  /**
   * Get the bean definition for 'seguradoraService'.
   */
  public static BeanDefinition getSeguradoraServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SeguradoraService.class);
    beanDefinition.setInstanceSupplier(getSeguradoraServiceInstanceSupplier());
    return beanDefinition;
  }
}
