package com.rodolfobrandao.aulajavacollectionsproject.config.auth;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Bean definitions for {@link SecurityConfiguration}.
 */
@Generated
public class SecurityConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'securityConfiguration'.
   */
  public static BeanDefinition getSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityConfiguration.class);
    beanDefinition.setTargetType(SecurityConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(SecurityConfiguration.class);
    InstanceSupplier<SecurityConfiguration> instanceSupplier = InstanceSupplier.using(SecurityConfiguration$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(SecurityConfiguration__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityFilterChain'.
   */
  private static BeanInstanceSupplier<SecurityFilterChain> getSecurityFilterChainInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SecurityFilterChain>forFactoryMethod(SecurityConfiguration.class, "securityFilterChain", HttpSecurity.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).securityFilterChain(args.get(0)));
  }

  /**
   * Get the bean definition for 'securityFilterChain'.
   */
  public static BeanDefinition getSecurityFilterChainBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SecurityFilterChain.class);
    beanDefinition.setInstanceSupplier(getSecurityFilterChainInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authenticationManager'.
   */
  private static BeanInstanceSupplier<AuthenticationManager> getAuthenticationManagerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationManager>forFactoryMethod(SecurityConfiguration.class, "authenticationManager", AuthenticationConfiguration.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).authenticationManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'authenticationManager'.
   */
  public static BeanDefinition getAuthenticationManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthenticationManager.class);
    beanDefinition.setInstanceSupplier(getAuthenticationManagerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(SecurityConfiguration.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SecurityConfiguration.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordEncoder.class);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }
}
