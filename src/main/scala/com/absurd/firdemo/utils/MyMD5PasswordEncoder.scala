package com.absurd.firdemo.utils

import org.springframework.security.authentication.encoding.Md5PasswordEncoder

/**
  * Created by Administrator on 2016/8/4.
  */
class MyMD5PasswordEncoder

object MyMD5PasswordEncoder{
  val SALT_CONTENT:String = "absurd"
  def encode(rawPass:String) : String = {
    encode(rawPass,SALT_CONTENT)
  }


  def encode(rawPass:String,salt:String) : String = {
    val md5 = new Md5PasswordEncoder()
    md5.setEncodeHashAsBase64(false)
    md5.encodePassword(rawPass, salt)
  }

  def valid(encPass:String,rawPass:String):Boolean  = {
    valid(encPass,rawPass,SALT_CONTENT)
  }
  def valid(encPass:String,rawPass:String,salt:String):Boolean = {
    val md5 = new Md5PasswordEncoder()
    md5.setEncodeHashAsBase64(false)
    md5.isPasswordValid(encPass,rawPass,salt)
  }
}
