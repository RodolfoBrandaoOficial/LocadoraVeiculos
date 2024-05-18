package org.springframework.boot.autoconfigure.security.oauth2.server.servlet;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.jwt.JwtDecoder;

/**
 * Bean definitions for {@link OAuth2AuthorizationServerJwtAutoConfiguration}.
 */
@Generated
public class OAuth2AuthorizationServerJwtAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'oAuth2AuthorizationServerJwtAutoConfiguration'.
   */
  public static BeanDefinition getOAuthAuthorizationServerJwtAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2AuthorizationServerJwtAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(OAuth2AuthorizationServerJwtAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwtDecoder'.
   */
  private static BeanInstanceSupplier<JwtDecoder> getJwtDecoderInstanceSupplier() {
    return BeanInstanceSupplier.<JwtDecoder>forFactoryMethod(OAuth2AuthorizationServerJwtAutoConfiguration.class, "jwtDecoder", JWKSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(OAuth2AuthorizationServerJwtAutoConfiguration.class).jwtDecoder(args.get(0)));
  }

  /**
   * Get the bean definition for 'jwtDecoder'.
   */
  public static BeanDefinition getJwtDecoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtDecoder.class);
    beanDefinition.setInstanceSupplier(getJwtDecoderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jwkSource'.
   */
  private static BeanInstanceSupplier<JWKSource> getJwkSourceInstanceSupplier() {
    return BeanInstanceSupplier.<JWKSource>forFactoryMethod(OAuth2AuthorizationServerJwtAutoConfiguration.class, "jwkSource")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(OAuth2AuthorizationServerJwtAutoConfiguration.class).jwkSource());
  }

  /**
   * Get the bean definition for 'jwkSource'.
   */
  public static BeanDefinition getJwkSourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JWKSource.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(JWKSource.class, SecurityContext.class));
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getJwkSourceInstanceSupplier());
    return beanDefinition;
  }
}
