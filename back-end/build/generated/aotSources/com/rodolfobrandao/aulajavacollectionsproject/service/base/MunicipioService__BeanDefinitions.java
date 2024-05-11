package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link MunicipioService}.
 */
@Generated
public class MunicipioService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'municipioService'.
   */
  private static BeanInstanceSupplier<MunicipioService> getMunicipioServiceInstanceSupplier() {
    return BeanInstanceSupplier.<MunicipioService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new MunicipioService(args.get(0)));
  }

  /**
   * Get the bean definition for 'municipioService'.
   */
  public static BeanDefinition getMunicipioServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MunicipioService.class);
    beanDefinition.setInstanceSupplier(getMunicipioServiceInstanceSupplier());
    return beanDefinition;
  }
}
