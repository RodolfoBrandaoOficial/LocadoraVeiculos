package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.CarroService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CarroCtl}.
 */
@Generated
public class CarroCtl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'carroCtl'.
   */
  private static BeanInstanceSupplier<CarroCtl> getCarroCtlInstanceSupplier() {
    return BeanInstanceSupplier.<CarroCtl>forConstructor(CarroService.class)
            .withGenerator((registeredBean, args) -> new CarroCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'carroCtl'.
   */
  public static BeanDefinition getCarroCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CarroCtl.class);
    beanDefinition.setInstanceSupplier(getCarroCtlInstanceSupplier());
    return beanDefinition;
  }
}
