package com.absurd.firdemo.dto

import scala.beans.BeanProperty

/**
  * Created by Administrator on 2016/8/4.
  */
class MessageDTO {
  @BeanProperty
  var msg:String = _
  @BeanProperty
  var code : Int = _
}
