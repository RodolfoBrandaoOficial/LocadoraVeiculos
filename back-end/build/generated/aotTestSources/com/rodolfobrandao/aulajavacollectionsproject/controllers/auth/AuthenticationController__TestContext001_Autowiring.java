package com.rodolfobrandao.aulajavacollectionsproject.controllers.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AuthenticationController}.
 */
@Generated
public class AuthenticationController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuthenticationController apply(RegisteredBean registeredBean,
      AuthenticationController instance) {
    AutowiredFieldValueResolver.forRequiredField("authenticationManager").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("repository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("tokenService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
