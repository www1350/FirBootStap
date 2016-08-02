package com.absurd.firdemo.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.annotation.meta.field
import scala.beans.BeanProperty

/**
  * Created by Administrator on 2016/8/2.
  */
@Entity
@Table(name = "t_role")
class Role {
  @(Id@field)
  @(GeneratedValue@field)
  @(Column@field)(name = "id")
  @JsonIgnore
  var id:Long = null.asInstanceOf[Long]

  @(Column@field)(name = "name")
  @BeanProperty
  var name:String = null.asInstanceOf[String]

  @(Column@field)(name = "rolecode")
  @BeanProperty
  var roleCode:String = null.asInstanceOf[String]
}
