package com.absurd.firdemo.security

import java.util

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.encoding.Md5PasswordEncoder
import org.springframework.security.authentication.{AuthenticationProvider, BadCredentialsException, UsernamePasswordAuthenticationToken}
import org.springframework.security.core.{Authentication, GrantedAuthority}
import org.springframework.security.core.userdetails.UserDetails

/**
  * Created by Administrator on 2016/8/4.
  */
@Bean(name = Array("myAuthenticationProvider"))
class MyAuthenticationProvider extends AuthenticationProvider {
  @Qualifier(value = "securityUserDetailsService") var securityUserDetailsService:SecurityUserDetailsService = _
  override def authenticate(authentication: Authentication): Authentication = {
    val username = authentication.getName()
    val password = authentication.getCredentials()
    val user:UserDetails=  securityUserDetailsService.loadUserByUsername(username)
    if(user == null){
      throw new BadCredentialsException("Username not found.")
    }

    val encoder : Md5PasswordEncoder = new Md5PasswordEncoder()
    encoder.setEncodeHashAsBase64(true)
    //加密过程在这里体现
    if (!(encoder.encodePassword(password.toString(),username)).equals(user.getPassword())) {
      throw new BadCredentialsException("Wrong password.");
    }

    val authorities = user.getAuthorities()
    new UsernamePasswordAuthenticationToken(user, password, authorities)

  }
  override def supports(aClass: java.lang.Class[_]): Boolean = true
}
