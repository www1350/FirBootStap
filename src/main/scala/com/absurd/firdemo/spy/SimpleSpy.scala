package com.absurd.firdemo.spy

import java.nio.charset.Charset

import scala.io.Source
import scala.util.matching.Regex

/**
  * Created by Administrator on 2016/8/5.
  */
class SimpleSpy {

}
object  SimpleSpy{
  def getUrl(url:String):String = {
    Source.fromURL(url,"GBK").mkString
  }
  def main(args: Array[String]): Unit = {
    println(SimpleSpy.getChaset("http://www.163.com")+"")
  }

  def getChaset(url:String):String = {
    val pattern =  "charset[\\s]*=(\")*[0-9a-zA-Z\\-]+\"".r
    val lines =  Source.fromURL(url,"GBK").mkString
   val input = pattern.findFirstMatchIn(lines).mkString
    val MatchStock = """([a-zA-Z]+)=([0-9a-zA-Z]+)""".r
    input match {
      case MatchStock(stock, price) => printf("stock=%s,price=%s\n", stock,price)
      case _ => println("invalid input " + input)
    }
    "1"

  }

}
