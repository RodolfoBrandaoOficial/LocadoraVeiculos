package com.rodolfobrandao.aulajavacollectionsproject.controllers.tools;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SearchCtl}.
 */
@Generated
public class SearchCtl__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SearchCtl apply(RegisteredBean registeredBean, SearchCtl instance) {
    AutowiredFieldValueResolver.forRequiredField("searchService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}