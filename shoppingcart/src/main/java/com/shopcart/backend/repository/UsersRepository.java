package com.shopcart.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopcart.backend.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{

	public List<Users> findByEmailAndPassword(String email,String password);
	
	public List<Users> findByEmail(String email);
//	@Modifying
//	@Query("UPDATE Users SET password=(:password) WHERE email=(:email)")
//	public int updatePassword(@Param("password")String password, @Param("email")String email);
}
