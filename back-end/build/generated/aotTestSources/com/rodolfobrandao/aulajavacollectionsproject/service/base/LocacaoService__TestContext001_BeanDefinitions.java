package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link LocacaoService}.
 */
@Generated
public class LocacaoService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'locacaoService'.
   */
  private static BeanInstanceSupplier<LocacaoService> getLocacaoServiceInstanceSupplier() {
    return BeanInstanceSupplier.<LocacaoService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new LocacaoService(args.get(0)));
  }

  /**
   * Get the bean definition for 'locacaoService'.
   */
  public static BeanDefinition getLocacaoServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LocacaoService.class);
    beanDefinition.setInstanceSupplier(getLocacaoServiceInstanceSupplier());
    return beanDefinition;
  }
}
