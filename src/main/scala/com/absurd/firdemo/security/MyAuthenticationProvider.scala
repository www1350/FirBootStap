package com.absurd.firdemo.security

import java.util

import com.absurd.firdemo.utils.MyMD5PasswordEncoder
import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.encoding.Md5PasswordEncoder
import org.springframework.security.authentication.{AuthenticationProvider, BadCredentialsException, UsernamePasswordAuthenticationToken}
import org.springframework.security.core.{Authentication, GrantedAuthority}
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

/**
  * Created by Administrator on 2016/8/4.
  */
@Component
class MyAuthenticationProvider extends AuthenticationProvider {
  @Autowired var securityUserDetailsService:SecurityUserDetailsService = _
  override def authenticate(authentication: Authentication): Authentication = {
    val username = authentication.getName()
    val password = authentication.getCredentials()
    val user:UserDetails=  securityUserDetailsService.loadUserByUsername(username)
    if(user == null){
      throw new BadCredentialsException("Username not found.")
    }


    //加密过程在这里体现
    if (MyMD5PasswordEncoder.valid(user.getPassword(),password.toString())) {
      throw new BadCredentialsException("Wrong password.");
    }

    val authorities = user.getAuthorities()
    new UsernamePasswordAuthenticationToken(user, password, authorities)

  }
  override def supports(aClass: java.lang.Class[_]): Boolean = true
}
