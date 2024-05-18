package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.SeguradoratelefoneService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SeguradoratelefoneCtl}.
 */
@Generated
public class SeguradoratelefoneCtl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'seguradoratelefoneCtl'.
   */
  private static BeanInstanceSupplier<SeguradoratelefoneCtl> getSeguradoratelefoneCtlInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SeguradoratelefoneCtl>forConstructor(SeguradoratelefoneService.class)
            .withGenerator((registeredBean, args) -> new SeguradoratelefoneCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'seguradoratelefoneCtl'.
   */
  public static BeanDefinition getSeguradoratelefoneCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SeguradoratelefoneCtl.class);
    beanDefinition.setInstanceSupplier(getSeguradoratelefoneCtlInstanceSupplier());
    return beanDefinition;
  }
}
