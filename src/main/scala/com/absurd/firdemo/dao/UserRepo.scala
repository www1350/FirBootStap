package com.absurd.firdemo.dao

import com.absurd.firdemo.model.User
import org.springframework.data.jpa.repository.JpaRepository

/**
  * Created by Administrator on 2016/7/27.
  */

trait UserRepo extends JpaRepository[User, java.lang.Long] {

}
