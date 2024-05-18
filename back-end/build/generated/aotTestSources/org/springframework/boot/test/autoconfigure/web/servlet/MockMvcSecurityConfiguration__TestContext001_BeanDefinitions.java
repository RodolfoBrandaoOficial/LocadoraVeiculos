package org.springframework.boot.test.autoconfigure.web.servlet;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MockMvcSecurityConfiguration}.
 */
@Generated
public class MockMvcSecurityConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'mockMvcSecurityConfiguration'.
   */
  public static BeanDefinition getMockMvcSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MockMvcSecurityConfiguration.class);
    beanDefinition.setInstanceSupplier(MockMvcSecurityConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'securityMockMvcBuilderCustomizer'.
   */
  private static BeanInstanceSupplier<MockMvcSecurityConfiguration.SecurityMockMvcBuilderCustomizer> getSecurityMockMvcBuilderCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MockMvcSecurityConfiguration.SecurityMockMvcBuilderCustomizer>forFactoryMethod(MockMvcSecurityConfiguration.class, "securityMockMvcBuilderCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MockMvcSecurityConfiguration.class).securityMockMvcBuilderCustomizer());
  }

  /**
   * Get the bean definition for 'securityMockMvcBuilderCustomizer'.
   */
  public static BeanDefinition getSecurityMockMvcBuilderCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MockMvcSecurityConfiguration.SecurityMockMvcBuilderCustomizer.class);
    beanDefinition.setInstanceSupplier(getSecurityMockMvcBuilderCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
