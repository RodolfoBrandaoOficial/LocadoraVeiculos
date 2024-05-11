package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.MunicipioService;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MunicipioCtl}.
 */
@Generated
public class MunicipioCtl__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'municipioCtl'.
   */
  private static BeanInstanceSupplier<MunicipioCtl> getMunicipioCtlInstanceSupplier() {
    return BeanInstanceSupplier.<MunicipioCtl>forConstructor(MunicipioService.class)
            .withGenerator((registeredBean, args) -> new MunicipioCtl(args.get(0)));
  }

  /**
   * Get the bean definition for 'municipioCtl'.
   */
  public static BeanDefinition getMunicipioCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MunicipioCtl.class);
    beanDefinition.setInstanceSupplier(getMunicipioCtlInstanceSupplier());
    return beanDefinition;
  }
}
