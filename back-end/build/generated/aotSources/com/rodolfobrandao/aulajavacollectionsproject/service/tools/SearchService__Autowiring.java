package com.rodolfobrandao.aulajavacollectionsproject.service.tools;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SearchService}.
 */
@Generated
public class SearchService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SearchService apply(RegisteredBean registeredBean, SearchService instance) {
    AutowiredFieldValueResolver.forRequiredField("jdbcOperations").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
