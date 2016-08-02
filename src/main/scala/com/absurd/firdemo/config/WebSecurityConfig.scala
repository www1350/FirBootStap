package com.absurd.firdemo.config

import com.absurd.firdemo.security.{MyAccessDecisionManager, MySecurityMetadataSource, SecurityUserDetailsService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig extends WebSecurityConfigurerAdapter{
  @Autowired var securityUserDetailsService:SecurityUserDetailsService = _
  @Autowired var  accessDecisionManager: MyAccessDecisionManager = _
  @Autowired var securityMetadataSource:MySecurityMetadataSource = _
  override def configure(auth: AuthenticationManagerBuilder): Unit = auth.userDetailsService(securityUserDetailsService)

  def  filterSecurityInterceptor:FilterSecurityInterceptor ={
    val filterSecurityInterceptor = new FilterSecurityInterceptor
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