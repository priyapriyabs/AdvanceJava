package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.ImageUpdateDTO;

@Repository
public interface ImageUploadRepo extends JpaRepository<ImageUpdateDTO, Integer>{

	@Query("select i from ImageUpdateDTO i where i.userId=:userId")
	ImageUpdateDTO findByUserId(@Param("userId") int userId);
	
	@Query("select i from ImageUpdateDTO i where i.userId=:userId")
	ImageUpdateDTO deactivateAllImagesForUser(@Param("userId")int  userId);
}
