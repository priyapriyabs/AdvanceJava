package com.priyanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.dto.UserParkingDTO;
import com.priyanka.entity.UserParkingEntity;

@Repository
public interface UserParkingRepo extends JpaRepository<UserParkingEntity, Integer>{

	@Query("select aa from UserParkingEntity aa where aa.userId=:userId")
	 List<UserParkingEntity> findAllByUserId(@Param("userId") int userId);
	
	@Query("select aa from UserParkingEntity aa where aa.vehicleNo=:vehicleNo")
 UserParkingEntity	findByVehicalNumber(@Param("vehicleNo")String vehicleNo);
	
	@Query("select aa from UserParkingEntity aa where aa.vehicleNo=:vehicleNo")
	UserParkingEntity deleteUserParkingEntity(@Param("vehicleNo")String vehicleNo);
	
}
