package com.argProgramaSpallione.ArgentinaPrograma.Repositories;

import com.argProgramaSpallione.ArgentinaPrograma.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
  
  @Query(value="SELECT * FROM user c WHERE c.username LIKE :username LIMIT 1", nativeQuery = true)
	public User findByUsername(
			@Param("username") String username);

}
