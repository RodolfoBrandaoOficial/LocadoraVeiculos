package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link CarroService}.
 */
@Generated
public class CarroService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'carroService'.
   */
  private static BeanInstanceSupplier<CarroService> getCarroServiceInstanceSupplier() {
    return BeanInstanceSupplier.<CarroService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new CarroService(args.get(0)));
  }

  /**
   * Get the bean definition for 'carroService'.
   */
  public static BeanDefinition getCarroServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CarroService.class);
    beanDefinition.setInstanceSupplier(getCarroServiceInstanceSupplier());
    return beanDefinition;
  }
}
