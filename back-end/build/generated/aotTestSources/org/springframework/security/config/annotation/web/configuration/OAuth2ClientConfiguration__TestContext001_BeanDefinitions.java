package org.springframework.security.config.annotation.web.configuration;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OAuth2ClientConfiguration}.
 */
@Generated
public class OAuth2ClientConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'oAuth2ClientConfiguration'.
   */
  public static BeanDefinition getOAuthClientConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2ClientConfiguration.class);
    beanDefinition.setInstanceSupplier(OAuth2ClientConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerConfiguration}.
   */
  @Generated
  public static class OAuth2AuthorizedClientManagerConfiguration {
    /**
     * Get the bean definition for 'oAuth2AuthorizedClientManagerConfiguration'.
     */
    public static BeanDefinition getOAuthAuthorizedClientManagerConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerConfiguration.class);
      beanDefinition.setInstanceSupplier(OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'authorizedClientManagerRegistrar'.
     */
    private static BeanInstanceSupplier<OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerRegistrar> getAuthorizedClientManagerRegistrarInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerRegistrar>forFactoryMethod(OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerConfiguration.class, "authorizedClientManagerRegistrar")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerConfiguration.class).authorizedClientManagerRegistrar());
    }

    /**
     * Get the bean definition for 'authorizedClientManagerRegistrar'.
     */
    public static BeanDefinition getAuthorizedClientManagerRegistrarBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2ClientConfiguration.OAuth2AuthorizedClientManagerRegistrar.class);
      beanDefinition.setInstanceSupplier(getAuthorizedClientManagerRegistrarInstanceSupplier());
      return beanDefinition;
    }
  }

  /**
   * Bean definitions for {@link OAuth2ClientConfiguration.OAuth2ClientWebMvcSecurityConfiguration}.
   */
  @Generated
  public static class OAuth2ClientWebMvcSecurityConfiguration {
    /**
     * Get the bean definition for 'oAuth2ClientWebMvcSecurityConfiguration'.
     */
    public static BeanDefinition getOAuthClientWebMvcSecurityConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(OAuth2ClientConfiguration.OAuth2ClientWebMvcSecurityConfiguration.class);
      InstanceSupplier<OAuth2ClientConfiguration.OAuth2ClientWebMvcSecurityConfiguration> instanceSupplier = InstanceSupplier.using(OAuth2ClientConfiguration.OAuth2ClientWebMvcSecurityConfiguration::new);
      instanceSupplier = instanceSupplier.andThen(OAuth2ClientConfiguration_OAuth2ClientWebMvcSecurityConfiguration__TestContext001_Autowiring::apply);
      beanDefinition.setInstanceSupplier(instanceSupplier);
      return beanDefinition;
    }
  }
}