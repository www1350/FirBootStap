package com.absurd.firdemo.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.annotation.meta.field
import scala.beans.BeanProperty

/**
  * Created by Administrator on 2016/8/3.
  */
@Entity
@Table(name = "t_permit")
class Permit {
  @(Id@field)
  @(GeneratedValue@field)
  @(Column@field)(name = "id")
  @JsonIgnore
  var id:Long = null.asInstanceOf[Long]

  @(Column@field)(name = "uid")
  @BeanProperty
  var uid:Long = null.asInstanceOf[Long]


  @(Column@field)(name = "rid")
  @BeanProperty
  var rid:Long = null.asInstanceOf[Long]
}
