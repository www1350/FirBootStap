package com.absurd.firdemo.service

import com.absurd.firdemo.dao.RoleDao
import com.absurd.firdemo.model.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Created by Administrator on 2016/8/2.
  */
@Service
@Transactional
class RoleService {
  @Autowired var roleDao : RoleDao = _
  def getUserRoles(uid : Long) = roleDao.getUserRoles(uid)
}
