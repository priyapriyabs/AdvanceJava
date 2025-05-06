package com.priyanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.priyanka.entity.AdminParkingEntity;

@Repository
public interface AdminParkingRepo extends JpaRepository<AdminParkingEntity, Integer>{

	@Query("select aa from AdminParkingEntity aa where aa.location=:location and aa.vehicleType=:vehicleType and aa.engineType=:engineType and aa.classification=:classification and aa.term=:term")
	AdminParkingEntity findByLocationAndVehicleTypeAndEngineTypeAndClsAndTerm(@Param("location")String location,@Param("vehicleType") String vehicleType,@Param("engineType") String engineType,@Param("classification") String classification,@Param("term") String term);

     List<AdminParkingEntity> findByLocation(@Param("location") String location);
}
