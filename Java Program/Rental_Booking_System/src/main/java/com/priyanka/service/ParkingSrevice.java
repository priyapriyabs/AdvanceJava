package com.priyanka.service;

import java.util.List;
import java.util.Map;

import com.priyanka.dto.AdminDTO;
import com.priyanka.dto.AdminParkingDTO;
import com.priyanka.dto.UserDTO;
import com.priyanka.dto.UserParkingDTO;
import com.priyanka.entity.AdminEntity;
import com.priyanka.entity.AdminParkingEntity;
import com.priyanka.entity.UserEntity;

public interface ParkingSrevice {

	void adminAccountCreate(AdminEntity adminEntity);
	
AdminEntity	getAdminEmail(String adminEmail);

public AdminDTO validateCredential(String adminEmail, String password);

void mailSendToAdmin(AdminEntity adminEntity);

boolean adminParkingAcountCreate(AdminParkingEntity adminParkingEntity);

boolean saveAdminParkingDTO(AdminParkingDTO dto);
	
	AdminParkingDTO adminParkingFieldsExist(String location, String vehicleType, String engineType, String classification,
			String term);

      List<AdminParkingDTO> findByLocation(String location);
      
   void   mailSendToUserAndParkingInfo(String email,String name,UserParkingDTO updto);

boolean saveUserAndUserParkingDate(UserDTO userDTO,UserParkingDTO userParkingDTO);

    UserEntity isUserEmailExist(String email);
    
    boolean sendOTPToUserEmail(String email,String name,String otp);
   
   boolean genarateOTPToUser(String email);
   
   boolean validateOTP(String email, String otp);
   
 Map<String, Long>  findPamentDueDays(String email);
 
   UserParkingDTO findByVehicalNumber(String vehicleNo);

   boolean addUserParkingInfo(UserParkingDTO upDto, String email);
   
     List<UserParkingDTO> findAllById(String email);
     
     boolean updateUserParkingInfo(UserParkingDTO upDto);
     
     boolean deleteUserParkingEntityByVehicleNo(String vehicleNo);

boolean updatePayment(String vehicleNo);

     List<UserParkingDTO> findAll();
}
