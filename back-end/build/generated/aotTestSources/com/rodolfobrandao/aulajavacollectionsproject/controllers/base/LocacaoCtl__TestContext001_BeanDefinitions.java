package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.LocacaoService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LocacaoCtl}.
 */
@Generated
public class LocacaoCtl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'locacaoCtl'.
   */
  private static BeanInstanceSupplier<LocacaoCtl> getLocacaoCtlInstanceSupplier() {
    return BeanInstanceSupplier.<LocacaoCtl>forConstructor(LocacaoService.class)
            .withGenerator((registeredBean, args) -> new LocacaoCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'locacaoCtl'.
   */
  public static BeanDefinition getLocacaoCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LocacaoCtl.class);
    beanDefinition.setInstanceSupplier(getLocacaoCtlInstanceSupplier());
    return beanDefinition;
  }
}
