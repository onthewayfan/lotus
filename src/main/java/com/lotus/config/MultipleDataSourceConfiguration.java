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

    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();

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
            mutablePropertyValues.addPropertyValue("password",dataSourceProperties.getPassword());
            mutablePropertyValues.addPropertyValue("url",dataSourceProperties.getUrl());
            mutablePropertyValues.addPropertyValue("driverClassName",dataSourceProperties.getDriverClassName());
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        String topStr = "custom.datasource.";
        String names = environment.getProperty(topStr+"names");
        String[] dsPrefixs = names.split(",");
        for (String dsPrefix : dsPrefixs){
            DataSourceProperties dataSourceProperties = this.getDataSourceProperties(environment,topStr+dsPrefix+".");
            if (dataSourceProperties==null){
                break;
            }
            dataSourceMap.put(dsPrefix,dataSourceProperties);
        }
    }

    private DataSourceProperties getDataSourceProperties(Environment environment,String prefix){
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setName(environment.getProperty(prefix+"name"));
        dataSourceProperties.setPassword(environment.getProperty(prefix+"password"));
        Class<? extends DataSource> type = null;
        try {
            type = (Class<? extends DataSource>) Class.forName(environment.getProperty(prefix+"type"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dataSourceProperties.setType(type);
        dataSourceProperties.setDriverClassName(environment.getProperty(prefix+"driver-class-name"));
        dataSourceProperties.setUrl(environment.getProperty(prefix+"url"));
        return dataSourceProperties;
    }
}
