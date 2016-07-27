package com.absurd.firdemo.service

import com.absurd.firdemo.dao.UserRepo
import com.absurd.firdemo.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Created by Administrator on 2016/7/27.
  */
@Service
@Transactional
class UserService {
  @Autowired  var userRepo:UserRepo = _
  def  getAll:  java.util.List[User] = userRepo.findAll()
//def  getAll:  java.util.List[User] = {
// val list =  new  java.util.ArrayList[User]()
// val u = new User()
//  u.username="a"
//  u.password="b"
//  list.add(u)
//  list
//}
}
