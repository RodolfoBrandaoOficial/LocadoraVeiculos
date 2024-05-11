package com.rodolfobrandao.aulajavacollectionsproject.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SecurityConfiguration}.
 */
@Generated
public class SecurityConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SecurityConfiguration apply(RegisteredBean registeredBean,
      SecurityConfiguration instance) {
    instance.securityFilter = AutowiredFieldValueResolver.forRequiredField("securityFilter").resolve(registeredBean);
    return instance;
  }
}
