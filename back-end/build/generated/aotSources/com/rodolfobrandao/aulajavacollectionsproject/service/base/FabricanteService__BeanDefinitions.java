package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link FabricanteService}.
 */
@Generated
public class FabricanteService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'fabricanteService'.
   */
  private static BeanInstanceSupplier<FabricanteService> getFabricanteServiceInstanceSupplier() {
    return BeanInstanceSupplier.<FabricanteService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new FabricanteService(args.get(0)));
  }

  /**
   * Get the bean definition for 'fabricanteService'.
   */
  public static BeanDefinition getFabricanteServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FabricanteService.class);
    beanDefinition.setInstanceSupplier(getFabricanteServiceInstanceSupplier());
    return beanDefinition;
  }
}
