package com.absurd.firdemo.security



import java.util

import com.absurd.firdemo.model.{Role, User}
import com.absurd.firdemo.service.{RoleService, UserService}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.{UserDetails, UserDetailsService, UsernameNotFoundException}

import scala.collection.mutable
import collection.JavaConverters._

/**
  * Created by Administrator on 2016/8/2.
  */
@Bean(name = Array("securityUserDetailsService"))
class SecurityUserDetailsService extends  UserDetailsService{
  val logger = LoggerFactory.getLogger(classOf[SecurityUserDetailsService])
  @Autowired var userService : UserService = _
  @Autowired var roleService : RoleService = _

  override def loadUserByUsername(username: String): UserDetails = {
    val user = userService.getUserByUsername(username)
    if(user == null) throw  new UsernameNotFoundException("User Not Found:"+username);
    val grantedAuths : util.Collection[GrantedAuthority] = obtionGrantedAuthorities(user)
     val enables :Boolean = true
     val accountNonExpired:Boolean  = true
     val credentialsNonExpired:Boolean  = true
     val accountNonLocked:Boolean  = true
    logger.info("aaa")
    	new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enables, accountNonExpired, credentialsNonExpired,
      accountNonLocked, grantedAuths)

  }

  private  def obtionGrantedAuthorities(user : User) : util.Collection[GrantedAuthority] = {
    val roles:List[Role] = userService.getUserRoles(user.getId)
    val authSet:util.Set[GrantedAuthority]  = new util.HashSet[GrantedAuthority]()
    for(r <- roles)
    authSet.add(new SimpleGrantedAuthority(r.getRoleCode))
    authSet
  }
}
