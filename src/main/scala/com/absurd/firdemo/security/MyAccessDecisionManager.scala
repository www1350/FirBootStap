package com.absurd.firdemo.security

import java.nio.file.AccessDeniedException
import java.util

import org.springframework.context.annotation.Bean
import org.springframework.security.access.{AccessDecisionManager, ConfigAttribute}
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component

/**
  * authentication用户信息，object访问的url，configAttributes url对应的角色
  * Created by Administrator on 2016/8/2.
  */
@Bean
class MyAccessDecisionManager extends  AccessDecisionManager{
  override def decide(authentication: Authentication, o: scala.Any, collection: util.Collection[ConfigAttribute]): Unit = {
   val configA = collection.iterator()

    while(configA.hasNext){
     val e:ConfigAttribute = configA.next()
      if(authentication.getPrincipal().asInstanceOf[User].getAuthorities().contains(e))
        return
    }
    throw new AccessDeniedException("没有权限")

  }

  override def supports(configAttribute: ConfigAttribute): Boolean = true

  override def supports(aClass: Class[_]): Boolean = true
}
