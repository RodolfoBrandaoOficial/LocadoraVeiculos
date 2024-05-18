package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.EstadoService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link EstadoCtl}.
 */
@Generated
public class EstadoCtl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'estadoCtl'.
   */
  private static BeanInstanceSupplier<EstadoCtl> getEstadoCtlInstanceSupplier() {
    return BeanInstanceSupplier.<EstadoCtl>forConstructor(EstadoService.class)
            .withGenerator((registeredBean, args) -> new EstadoCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'estadoCtl'.
   */
  public static BeanDefinition getEstadoCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EstadoCtl.class);
    beanDefinition.setInstanceSupplier(getEstadoCtlInstanceSupplier());
    return beanDefinition;
  }
}
