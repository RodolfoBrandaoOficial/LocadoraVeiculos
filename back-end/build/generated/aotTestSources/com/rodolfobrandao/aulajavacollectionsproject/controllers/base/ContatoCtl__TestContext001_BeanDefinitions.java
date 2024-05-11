package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.ContatoService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ContatoCtl}.
 */
@Generated
public class ContatoCtl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'contatoCtl'.
   */
  private static BeanInstanceSupplier<ContatoCtl> getContatoCtlInstanceSupplier() {
    return BeanInstanceSupplier.<ContatoCtl>forConstructor(ContatoService.class)
            .withGenerator((registeredBean, args) -> new ContatoCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'contatoCtl'.
   */
  public static BeanDefinition getContatoCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ContatoCtl.class);
    beanDefinition.setInstanceSupplier(getContatoCtlInstanceSupplier());
    return beanDefinition;
  }
}
