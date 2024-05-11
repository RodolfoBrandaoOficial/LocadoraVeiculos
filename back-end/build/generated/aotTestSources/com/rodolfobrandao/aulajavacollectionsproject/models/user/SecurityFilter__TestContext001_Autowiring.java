package com.rodolfobrandao.aulajavacollectionsproject.models.user;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SecurityFilter}.
 */
@Generated
public class SecurityFilter__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SecurityFilter apply(RegisteredBean registeredBean, SecurityFilter instance) {
    instance.tokenService = AutowiredFieldValueResolver.forRequiredField("tokenService").resolve(registeredBean);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
