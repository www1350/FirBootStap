package com.absurd.firdemo.config

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{SpringBootApplication, EnableAutoConfiguration}
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.{ComponentScan, Configuration}

/**
  * Created by Administrator on 2016/7/27.
  */
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = Array("com.absurd"))
class Application extends SpringBootServletInitializer{
  override def configure(builder: SpringApplicationBuilder): SpringApplicationBuilder = builder.sources(classOf[Application])

}
object Application extends App{
    SpringApplication.run(classOf[Application], args: _*)
}