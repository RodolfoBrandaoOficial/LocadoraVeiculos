package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link EstadoService}.
 */
@Generated
public class EstadoService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'estadoService'.
   */
  private static BeanInstanceSupplier<EstadoService> getEstadoServiceInstanceSupplier() {
    return BeanInstanceSupplier.<EstadoService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new EstadoService(args.get(0)));
  }

  /**
   * Get the bean definition for 'estadoService'.
   */
  public static BeanDefinition getEstadoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EstadoService.class);
    beanDefinition.setInstanceSupplier(getEstadoServiceInstanceSupplier());
    return beanDefinition;
  }
}
