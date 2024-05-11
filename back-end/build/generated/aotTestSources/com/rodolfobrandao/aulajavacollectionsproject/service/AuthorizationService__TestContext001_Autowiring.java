package com.rodolfobrandao.aulajavacollectionsproject.service;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AuthorizationService}.
 */
@Generated
public class AuthorizationService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuthorizationService apply(RegisteredBean registeredBean,
      AuthorizationService instance) {
    instance.repository = AutowiredFieldValueResolver.forRequiredField("repository").resolve(registeredBean);
    return instance;
  }
}
