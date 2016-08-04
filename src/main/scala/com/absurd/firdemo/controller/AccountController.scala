package com.absurd.firdemo.controller

import com.absurd.firdemo.dto.MessageDTO
import com.absurd.firdemo.model.User
import com.absurd.firdemo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

/**
  * Created by Administrator on 2016/8/4.
  */
@Controller
@RequestMapping(value=Array("/account"))
class AccountController {

  @Autowired var userService: UserService = _
  val logger = LoggerFactory.getLogger(classOf[AccountController])

  @RequestMapping(value=Array("/login"),method=Array(RequestMethod.POST))
  def login:String = "login"

  @RequestMapping(value=Array("/register"),method=Array(RequestMethod.POST))
  @ResponseBody
  def register(@RequestParam(value = "username") username:String ,
               @RequestParam(value = "password") password :String ) :MessageDTO = {
    logger.error("aa"+username)
    val message: MessageDTO = new MessageDTO()
    userService.register(username, password)
    message
  }


  @RequestMapping(value = Array("/getUser"), method = Array(RequestMethod.POST))
  @ResponseBody
  def getUserByUsername(@RequestParam(value = "username") username: String): User = {

    userService.getUserByUsername(username)
  }
}
