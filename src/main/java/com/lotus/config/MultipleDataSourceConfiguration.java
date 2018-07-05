package com.lotus.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态创建多数据源，注册Spring中
 *
 *  执行顺序
 *  setEnvironment()->postProcessBeanDefinitionRegistry()->postProcessBeanFactory()
 */
@Configuration
public class MultipleDataSourceConfiguration implements BeanDefinitionRegistryPostProcessor,EnvironmentAware {

    private  ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();

    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

    private Map<String,DataSourceProperties> dataSourceMap = new HashMap<String,DataSourceProperties>();


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if (dataSourceMap.isEmpty()){
            return;
        }
        for (Map.Entry<String,DataSourceProperties> entry:dataSourceMap.entrySet()) {
            AnnotatedGenericBeanDefinition annotatedGenericBeanDefinition = new AnnotatedGenericBeanDefinition(entry.getValue().getType());
            ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(annotatedGenericBeanDefinition);
            annotatedGenericBeanDefinition.setScope(scopeMetadata.getScopeName());
            String beanName = entry.getKey()!=null?entry.getKey():this.beanNameGenerator.generateBeanName(annotatedGenericBeanDefinition,registry);
            AnnotationConfigUtils.processCommonDefinitionAnnotations(annotatedGenericBeanDefinition);
            BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(annotatedGenericBeanDefinition,beanName);
            BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder,registry);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (dataSourceMap.isEmpty()){
            return;
        }
        BeanDefinition beanDefinition = null;
        MutablePropertyValues mutablePropertyValues = null;
        for (Map.Entry<String,DataSourceProperties> entry:dataSourceMap.entrySet()) {
            beanDefinition = beanFactory.getBeanDefinition(entry.getKey());
            mutablePropertyValues = beanDefinition.getPropertyValues();
            DataSourceProperties dataSourceProperties = entry.getValue();
            mutablePropertyValues.addPropertyValue("username",dataSourceProperties.getName());
            mutablePropertyValues.addPropertyValue("userpassword",dataSourceProperties.getPassword());
            mutablePropertyValues.addPropertyValue("url",dataSourceProperties.getUrl());
            mutablePropertyValues.addPropertyValue("type",dataSourceProperties.getType());
            mutablePropertyValues.addPropertyValue("driverClassName",dataSourceProperties.getDriverClassName());
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        String topStr = "custom.datasource.";
        String names = environment.getProperty(topStr+"names");
        String[] dsPrefixs = names.split(",");
        for (String dsPrefix : dsPrefixs){
            String temp = environment.getProperty(topStr+dsPrefix);
            DataSourceProperties dataSourceProperties = environment.getProperty(topStr+dsPrefix,DataSourceProperties.class);
            if (dataSourceProperties==null){
                break;
            }
            dataSourceMap.put(dsPrefix,dataSourceProperties);
        }
    }
}
