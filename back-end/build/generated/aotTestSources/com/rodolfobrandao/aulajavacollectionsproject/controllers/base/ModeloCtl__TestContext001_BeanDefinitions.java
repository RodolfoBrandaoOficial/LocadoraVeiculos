package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.ModeloService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ModeloCtl}.
 */
@Generated
public class ModeloCtl__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'modeloCtl'.
   */
  private static BeanInstanceSupplier<ModeloCtl> getModeloCtlInstanceSupplier() {
    return BeanInstanceSupplier.<ModeloCtl>forConstructor(ModeloService.class)
            .withGenerator((registeredBean, args) -> new ModeloCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'modeloCtl'.
   */
  public static BeanDefinition getModeloCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ModeloCtl.class);
    beanDefinition.setInstanceSupplier(getModeloCtlInstanceSupplier());
    return beanDefinition;
  }
}
