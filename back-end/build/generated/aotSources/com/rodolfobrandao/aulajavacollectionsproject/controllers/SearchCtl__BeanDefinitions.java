package com.rodolfobrandao.aulajavacollectionsproject.controllers;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SearchCtl}.
 */
@Generated
public class SearchCtl__BeanDefinitions {
  /**
   * Get the bean definition for 'searchCtl'.
   */
  public static BeanDefinition getSearchCtlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SearchCtl.class);
    InstanceSupplier<SearchCtl> instanceSupplier = InstanceSupplier.using(SearchCtl::new);
    instanceSupplier = instanceSupplier.andThen(SearchCtl__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
