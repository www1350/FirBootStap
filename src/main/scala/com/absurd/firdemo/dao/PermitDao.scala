package com.absurd.firdemo.dao

import com.absurd.firdemo.model.Permit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
  * Created by Administrator on 2016/8/4.
  */
@Repository
trait PermitDao  extends JpaRepository[Permit, java.lang.Long] {

}
