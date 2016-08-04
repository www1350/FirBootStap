package com.absurd.firdemo.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.GenericGenerator

import scala.annotation.meta.field
import scala.beans.BeanProperty

/**
  * Created by Administrator on 2016/8/2.
  */
@Entity
@Table(name = "t_role")
class Role {
  @(Id@field)
  @GeneratedValue(strategy =GenerationType.AUTO)
  @(Column@field)(name = "id")
  @BeanProperty
  @JsonIgnore
  var id:Long = null.asInstanceOf[Long]

  @(Column@field)(name = "name")
  @BeanProperty
  var name:String = null.asInstanceOf[String]

  @(Column@field)(name = "rolecode")
  @BeanProperty
  var roleCode:String = null.asInstanceOf[String]

//  @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//  @BeanProperty
//  var permit:java.util.Set[Permit] = _
}
