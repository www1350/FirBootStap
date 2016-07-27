package com.absurd.firdemo.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RestController, RequestMethod, ResponseBody, RequestMapping}
import org.springframework.web.servlet.ModelAndView
import collection.JavaConverters._

/**
  * Created by Administrator on 2016/7/27.
  */
@RestController
@EnableAutoConfiguration
class HelloController {
  @RequestMapping(value = Array("/home"), method = Array(RequestMethod.GET))
  @ResponseBody
  def randomLong():ModelAndView = {
    new ModelAndView("index")
  }
  @RequestMapping(value = Array("/index"))
    def index:String = {
      "index"
    }

  @RequestMapping(value = Array("/hello"), method = Array(RequestMethod.GET))
  @ResponseBody
  def hello = {
//    Map[String, String]("Hello" -> "world").asJava
    Map[String, String]("Hello" -> "world")
  }

}
