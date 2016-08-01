package com.absurd.firdemo.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.annotation.meta.field
import scala.beans.BeanProperty

/**
  * Created by Administrator on 2016/7/27.
  */
@Entity
@Table(name = "t_user")
 class User  {
 @(Id@field)
 @(GeneratedValue@field)
 @(Column@field)(name = "uid")
  @JsonIgnore
 var id:Long = null.asInstanceOf[Long]

 @(Column@field)(name = "username")
  @BeanProperty
   var username:String = null.asInstanceOf[String]

 @(Column@field)(name = "password")
 @BeanProperty
   var password:String = null.asInstanceOf[String]


}
