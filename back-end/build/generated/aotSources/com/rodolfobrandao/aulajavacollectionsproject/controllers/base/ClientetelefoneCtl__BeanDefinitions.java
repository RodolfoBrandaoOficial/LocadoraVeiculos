package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.ClientetelefoneService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ClientetelefoneCtl}.
 */
@Generated
public class ClientetelefoneCtl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'clientetelefoneCtl'.
   */
  private static BeanInstanceSupplier<ClientetelefoneCtl> getClientetelefoneCtlInstanceSupplier() {
    return BeanInstanceSupplier.<ClientetelefoneCtl>forConstructor(ClientetelefoneService.class)
            .withGenerator((registeredBean, args) -> new ClientetelefoneCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'clientetelefoneCtl'.
   */
  public static BeanDefinition getClientetelefoneCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientetelefoneCtl.class);
    beanDefinition.setInstanceSupplier(getClientetelefoneCtlInstanceSupplier());
    return beanDefinition;
  }
}
