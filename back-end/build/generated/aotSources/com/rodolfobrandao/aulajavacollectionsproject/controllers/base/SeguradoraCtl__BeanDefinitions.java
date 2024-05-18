package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.SeguradoraService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SeguradoraCtl}.
 */
@Generated
public class SeguradoraCtl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'seguradoraCtl'.
   */
  private static BeanInstanceSupplier<SeguradoraCtl> getSeguradoraCtlInstanceSupplier() {
    return BeanInstanceSupplier.<SeguradoraCtl>forConstructor(SeguradoraService.class)
            .withGenerator((registeredBean, args) -> new SeguradoraCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'seguradoraCtl'.
   */
  public static BeanDefinition getSeguradoraCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SeguradoraCtl.class);
    beanDefinition.setInstanceSupplier(getSeguradoraCtlInstanceSupplier());
    return beanDefinition;
  }
}
