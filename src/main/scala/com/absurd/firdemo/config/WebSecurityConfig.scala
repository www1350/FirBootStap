package com.absurd.firdemo.config

import javax.annotation.Resource

import com.absurd.firdemo.security.{MyAccessDecisionManager, MyAuthenticationProvider, MySecurityMetadataSource, SecurityUserDetailsService}
import com.absurd.firdemo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor

/**
  * Created by Administrator on 2016/8/2.
  */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter{
  @Autowired var securityUserDetailsService:SecurityUserDetailsService = _
  @Autowired  var  accessDecisionManager: MyAccessDecisionManager = _
  @Autowired var securityMetadataSource:MySecurityMetadataSource = _
  @Autowired var myAuthenticationProvider:MyAuthenticationProvider = _
  val logger = LoggerFactory.getLogger(classOf[WebSecurityConfig])
//  override def configure(auth: AuthenticationManagerBuilder): Unit = auth.userDetailsService(securityUserDetailsService)
override def configure(auth: AuthenticationManagerBuilder): Unit = {
  auth.authenticationProvider(myAuthenticationProvider)
}

//  @Bean
  def  filterSecurityInterceptor:FilterSecurityInterceptor ={
    val filterSecurityInterceptor = new FilterSecurityInterceptor()
    filterSecurityInterceptor.setSecurityMetadataSource(securityMetadataSource)
    filterSecurityInterceptor.setAuthenticationManager(authenticationManager())
    filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager)
     filterSecurityInterceptor
  }


  override def configure(http: HttpSecurity): Unit = {
    http.authorizeRequests().antMatchers("/login.html","/index.html").anonymous()
    http.formLogin().loginPage("/login.html").failureUrl("/login.html?error=true").defaultSuccessUrl("/index.html").loginProcessingUrl("/login")
    http.logout().logoutSuccessUrl("/login.html").logoutUrl("/logout")
    http.addFilterBefore(filterSecurityInterceptor,classOf[FilterSecurityInterceptor])
    http.sessionManagement().invalidSessionUrl("/logout")

//    http.authorizeRequests().accessDecisionManager(accessDecisionManager).accessDeniedPage("/login")
//    http.httpBasic()
//    http.csrf().disable()


  }


}
