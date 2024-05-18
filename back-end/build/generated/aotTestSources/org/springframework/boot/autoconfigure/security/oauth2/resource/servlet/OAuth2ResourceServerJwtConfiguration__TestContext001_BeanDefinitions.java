package org.springframework.boot.autoconfigure.security.oauth2.resource.servlet;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

/**
 * Bean definitions for {@link OAuth2ResourceServerJwtConfiguration}.
 */
@Generated
public class OAuth2ResourceServerJwtConfiguration__TestContext001_BeanDefinitions {
  /**
   * Bean definitions for {@link OAuth2ResourceServerJwtConfiguration.JwtDecoderConfiguration}.
   */
  @Generated
  public static class JwtDecoderConfiguration {
    /**
     * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerJwtConfiguration$JwtDecoderConfiguration'.
     */
    private static BeanInstanceSupplier<OAuth2ResourceServerJwtConfiguration.JwtDecoderConfiguration> getJwtDecoderConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<OAuth2ResourceServerJwtConfiguration.JwtDecoderConfiguration>forConstructor(OAuth2ResourceServerProperties.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> new OAuth2ResourceServerJwtConfiguration.JwtDecoderConfiguration(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'jwtDecoderConfiguration'.
     */
    public static BeanDefinition getJwtDecoderConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2ResourceServerJwtConfiguration.JwtDecoderConfiguration.class);
      beanDefinition.setInstanceSupplier(getJwtDecoderConfigurationInstanceSupplier());
      return beanDefinition;
    }
  }
}
