package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.FabricanteService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FabricanteCtl}.
 */
@Generated
public class FabricanteCtl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'fabricanteCtl'.
   */
  private static BeanInstanceSupplier<FabricanteCtl> getFabricanteCtlInstanceSupplier() {
    return BeanInstanceSupplier.<FabricanteCtl>forConstructor(FabricanteService.class)
            .withGenerator((registeredBean, args) -> new FabricanteCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'fabricanteCtl'.
   */
  public static BeanDefinition getFabricanteCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FabricanteCtl.class);
    beanDefinition.setInstanceSupplier(getFabricanteCtlInstanceSupplier());
    return beanDefinition;
  }
}
