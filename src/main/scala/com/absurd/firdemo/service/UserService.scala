package com.absurd.firdemo.service

import com.absurd.firdemo.dao.{RoleDao, UserDao}
import com.absurd.firdemo.model.{Permit, Role, User}
import com.absurd.firdemo.utils.{ MyMD5PasswordEncoder}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import collection.JavaConverters._
/**
  * Created by Administrator on 2016/7/27.
  */
@Service
@Transactional
class UserService {
  @Autowired var userDao: UserDao = _
  @Autowired var roleDao: RoleDao = _
  def getAll: Iterable[User] = userDao.findAll.asScala

  def getUserList(page:Pageable) :  Iterable[User] = userDao.findAll(page).asScala

  def getUserByUsername(username: String): User = userDao.getUserByUsername(username)

  def register(username: String,password: String):Boolean = {
    if(userDao.getUserByUsername(username) != null) return false
    val user = new User()
    user.setUsername(username)
    user.setPassword(MyMD5PasswordEncoder.encode(password))
    userDao.save(user)
    true
  }



  //def  getAll:  java.util.List[User] = {
  // val list =  new  java.util.ArrayList[User]()
  // val u = new User()
  //  u.username="a"
  //  u.password="b"
  //  list.add(u)
  //  list
  //}
}
