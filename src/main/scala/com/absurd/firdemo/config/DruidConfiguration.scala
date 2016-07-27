package com.absurd.firdemo.config

import com.alibaba.druid.support.http.{WebStatFilter, StatViewServlet}
import org.springframework.boot.context.embedded.{FilterRegistrationBean, ServletRegistrationBean}
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Created by Administrator on 2016/7/27.
  */
@Configuration
class DruidConfiguration {
  @Bean def druidServlet:ServletRegistrationBean = {
    return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
  }



  @Bean def filterRegistrationBean:FilterRegistrationBean = {
    val filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new WebStatFilter());
    filterRegistrationBean.addUrlPatterns("/*");
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
    return filterRegistrationBean;
  }
}
