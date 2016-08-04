package com.absurd.firdemo.dao

import java.util.List
import com.absurd.firdemo.model.{Role, User}
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.stereotype.Repository

/**
  * Created by Administrator on 2016/8/2.
  */
@Repository
trait RoleDao extends JpaRepository[Role, java.lang.Long] {
  @Query(value="select r.* from t_role r,t_permit p where r.id = p.rid and p.uid=?1",nativeQuery=true)
  def getUserRoles(uid:Long) :List[Role]
}
