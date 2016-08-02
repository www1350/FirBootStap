package com.absurd.firdemo.security

import java.util

import org.springframework.context.annotation.Bean
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource

/**
  * 系统启动加载系统权限  用户登入验证权限,从数据库提取权限和资源，装配到HashMap中
  * Created by Administrator on 2016/8/2.
  */
@Bean
class MySecurityMetadataSource extends FilterInvocationSecurityMetadataSource{
  override def getAttributes(o: scala.Any): util.Collection[ConfigAttribute] = null

  override def getAllConfigAttributes: util.Collection[ConfigAttribute] = new util.ArrayList[ConfigAttribute];

  override def supports(aClass: Class[_]): Boolean = true
}
