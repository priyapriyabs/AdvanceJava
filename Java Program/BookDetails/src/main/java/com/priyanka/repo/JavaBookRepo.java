package com.priyanka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.priyanka.entity.JavaBookDetailsEntity;

@Repository
public interface JavaBookRepo extends JpaRepository<JavaBookDetailsEntity, Integer>{

	@Query("select b from JavaBookDetailsEntity b where b.email=:email")
	JavaBookDetailsEntity findByEmail(@Param("email") String email);
}
