package com.rodolfobrandao.aulajavacollectionsproject.config.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TokenService}.
 */
@Generated
public class TokenService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TokenService apply(RegisteredBean registeredBean, TokenService instance) {
    AutowiredFieldValueResolver.forRequiredField("secret").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
