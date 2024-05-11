package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link ContatoService}.
 */
@Generated
public class ContatoService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'contatoService'.
   */
  private static BeanInstanceSupplier<ContatoService> getContatoServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ContatoService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new ContatoService(args.get(0)));
  }

  /**
   * Get the bean definition for 'contatoService'.
   */
  public static BeanDefinition getContatoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ContatoService.class);
    beanDefinition.setInstanceSupplier(getContatoServiceInstanceSupplier());
    return beanDefinition;
  }
}
