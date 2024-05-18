package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.ClienteService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ClienteCtl}.
 */
@Generated
public class ClienteCtl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'clienteCtl'.
   */
  private static BeanInstanceSupplier<ClienteCtl> getClienteCtlInstanceSupplier() {
    return BeanInstanceSupplier.<ClienteCtl>forConstructor(ClienteService.class)
            .withGenerator((registeredBean, args) -> new ClienteCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'clienteCtl'.
   */
  public static BeanDefinition getClienteCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClienteCtl.class);
    beanDefinition.setInstanceSupplier(getClienteCtlInstanceSupplier());
    return beanDefinition;
  }
}
