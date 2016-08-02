package com.absurd.firdemo.dao

import com.absurd.firdemo.model.{Role, User}
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.stereotype.Repository

/**
  * Created by Administrator on 2016/8/2.
  */
@Repository
trait RoleDao extends JpaRepository[Role, java.lang.Long] {

}
