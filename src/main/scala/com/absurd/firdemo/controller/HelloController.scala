package com.absurd.firdemo.controller

import java.util

import com.absurd.firdemo.WordUtils
import com.absurd.firdemo.model.User
import com.absurd.firdemo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.ModelAndView

import collection.JavaConverters._


/**
  * Created by Administrator on 2016/7/27.
  */
@RestController
@EnableAutoConfiguration
class HelloController {

  @Autowired var userService: UserService = _
  val logger = LoggerFactory.getLogger(classOf[HelloController])


  @RequestMapping(value=Array("/login"),method=Array(RequestMethod.POST))
  def login:String = "login"

  @RequestMapping(value = Array("/home"), method = Array(RequestMethod.GET))
  @ResponseBody
  def randomLong( @PageableDefault(value=20,page=0)  page :Pageable ): ModelAndView = {
    val userList: java.util.Collection[User] = userService.getAll.asJavaCollection
    val map = Map[String,java.util.Collection[User]]("userList"-> userList)
    new ModelAndView("index",map.asJava)
//        val map = Map[String,String]("userList"-> "aa")
//        new ModelAndView("index",map.asJava)
//val map = Map[String,User]("userList"-> userList.head)
//        new ModelAndView("index",map.asJava)
  }

  @RequestMapping(value = Array("/getList"), method = Array(RequestMethod.GET))
  @ResponseBody
  def getList(@PageableDefault(value=20,page=0)  page :Pageable ): ModelAndView = {
    val userList: java.util.Collection[User] = userService.getUserList(page).asJavaCollection
    val map = Map[String,java.util.Collection[User]]("userList"-> userList)
    new ModelAndView("index",map.asJava)
    //        val map = Map[String,String]("userList"-> "aa")
    //        new ModelAndView("index",map.asJava)
    //val map = Map[String,User]("userList"-> userList.head)
    //        new ModelAndView("index",map.asJava)
  }

  @RequestMapping(value = Array("/index"))
  def index: String = {
    "index"
  }

  @RequestMapping(value = Array("/hello"), method = Array(RequestMethod.GET))
  @ResponseBody
  def hello = {
    //    Map[String, String]("Hello" -> "world").asJava
    Map[String, String]("Hello" -> "world")
  }


  @RequestMapping(value = Array("/getAll"), method = Array(RequestMethod.GET))
  @ResponseBody
  def getAll = {
    val userList: Iterable[User] = userService.getAll

    val strList = new util.ArrayList[String]()
    //求1-100奇数平方和
    logger.info("" + (0 /: (0 to 100)) ((s, i) => s + i % 2 * i * i))
    for (user: User <- userList)
      strList.add(user.username)
    WordUtils.matchNum(strList)

  }

  @RequestMapping(value = Array("/getUser/{username}"), method = Array(RequestMethod.GET))
  @ResponseBody
  def getUserByUsername(@PathVariable(value = "username") username: String): User = {

    userService.getUserByUsername(username)
  }
}
