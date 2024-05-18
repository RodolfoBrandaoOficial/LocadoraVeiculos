package com.rodolfobrandao.aulajavacollectionsproject.config.auth.oauth2;

import java.lang.SuppressWarnings;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link OAuth2ClientConfig}.
 */
@Generated
public class OAuth2ClientConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'oAuth2ClientConfig'.
   */
  @SuppressWarnings("deprecation")
  public static BeanDefinition getOAuthClientConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2ClientConfig.class);
    beanDefinition.setTargetType(OAuth2ClientConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(OAuth2ClientConfig.class);
    beanDefinition.setInstanceSupplier(OAuth2ClientConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
