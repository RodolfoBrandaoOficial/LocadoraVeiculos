package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link ModeloService}.
 */
@Generated
public class ModeloService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'modeloService'.
   */
  private static BeanInstanceSupplier<ModeloService> getModeloServiceInstanceSupplier() {
    return BeanInstanceSupplier.<ModeloService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new ModeloService(args.get(0)));
  }

  /**
   * Get the bean definition for 'modeloService'.
   */
  public static BeanDefinition getModeloServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ModeloService.class);
    beanDefinition.setInstanceSupplier(getModeloServiceInstanceSupplier());
    return beanDefinition;
  }
}
