package com.rodolfobrandao.aulajavacollectionsproject.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SearchService}.
 */
@Generated
public class SearchService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SearchService apply(RegisteredBean registeredBean, SearchService instance) {
    AutowiredFieldValueResolver.forRequiredField("jdbcOperations").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
