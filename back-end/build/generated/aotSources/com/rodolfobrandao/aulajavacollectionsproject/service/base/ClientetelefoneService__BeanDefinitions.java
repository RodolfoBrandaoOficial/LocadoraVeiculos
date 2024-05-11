package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.jdbc.core.simple.JdbcClient;

/**
 * Bean definitions for {@link ClientetelefoneService}.
 */
@Generated
public class ClientetelefoneService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'clientetelefoneService'.
   */
  private static BeanInstanceSupplier<ClientetelefoneService> getClientetelefoneServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ClientetelefoneService>forConstructor(JdbcClient.class)
            .withGenerator((registeredBean, args) -> new ClientetelefoneService(args.get(0)));
  }

  /**
   * Get the bean definition for 'clientetelefoneService'.
   */
  public static BeanDefinition getClientetelefoneServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ClientetelefoneService.class);
    beanDefinition.setInstanceSupplier(getClientetelefoneServiceInstanceSupplier());
    return beanDefinition;
  }
}
