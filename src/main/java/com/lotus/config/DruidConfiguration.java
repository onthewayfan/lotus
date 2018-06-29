package com.lotus.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 代码注册servlet和Filter
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidServlet(){
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //设置Ip白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //设置Ip黑名单
        servletRegistrationBean.addInitParameter("deny","172.16.12.249");
        //设置登录用户名
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        //设置登录密码
        servletRegistrationBean.addInitParameter("loginPassword","12345");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //设置忽略过滤形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.git,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
