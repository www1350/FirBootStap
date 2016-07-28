package com.absurd.firdemo.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.annotation.meta.field

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
   var username:String = null

 @(Column@field)(name = "password")
   var password:String = null


}
