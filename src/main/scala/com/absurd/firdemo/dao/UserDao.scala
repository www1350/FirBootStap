package com.absurd.firdemo.dao

import javax.persistence.EntityManager

import com.absurd.firdemo.model.{Role, User}
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
  * Created by Administrator on 2016/7/28.
  */
@Repository
trait UserDao extends JpaRepository[User, java.lang.Long]   {
  def getUserByUsername(username: String): User

  @Query(value="select r.* from t_role r,t_permit p where r.id = p.rid and p.uid=?1",nativeQuery=true)
  def getUserRoles(uid:Long) :List[Role]

}
