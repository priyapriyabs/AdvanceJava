package com.priyanka.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.priyanka.dto.AdminDTO;
import com.priyanka.dto.AdminParkingDTO;
import com.priyanka.dto.UserDTO;
import com.priyanka.dto.UserParkingDTO;
import com.priyanka.entity.AdminEntity;
import com.priyanka.entity.AdminParkingEntity;
import com.priyanka.entity.UserEntity;
import com.priyanka.entity.UserParkingEntity;
import com.priyanka.repository.AdminParkingRepo;
import com.priyanka.repository.AdminRepo;
import com.priyanka.repository.UserParkingRepo;
import com.priyanka.repository.UserRepo;
import com.priyanka.util.DateDifference;
import com.priyanka.util.GenerateOTP;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParkingServiceImpl implements ParkingSrevice {

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private AdminParkingRepo adminParkingRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserParkingRepo userParkingRepo;
	
	
	
//	@Autowired
//	private AdminEmailConfiguration adminEmailConfiguration;
	
	@Override
	public void adminAccountCreate(AdminEntity adminEntity) {
		adminEntity.setCreated_by(adminEntity.getName());
		adminEntity.setCreated_date(LocalDateTime.now());
		adminRepo.save(adminEntity);
	}
	
	@Override
	public AdminEntity getAdminEmail(String adminEmail) {
		
		return adminRepo.findByAdminEmail(adminEmail);
	}
	
	@Override
	public void mailSendToAdmin(AdminEntity adminEntity) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(adminEntity.getAdminEmail());
		message.setSubject("Email Login");
		message.setText("Dear " + adminEntity.getName() + " " + ", You have been successfully Signed Up,\n"
				+ "Please Sign in through this Email: " + adminEntity.getAdminEmail() + "\n "
						+ "\n\n\n\n\n\n "
						+ "\n "
						+"\n "
						+"\n "
						+"\n "
						+ "Thanks and Regards,\n" 
						+ " "
				+ "Rental_Parking_Team");
		javaMailSender.send(message);	
		
	}

	@Override
	public AdminDTO validateCredential(String adminEmail, String password) {
		if (adminEmail != null && password != null) {
			log.info("dto is not null");
			AdminEntity entity = adminRepo.findByAdminEmail(adminEmail);
			if (entity != null) {
				if (entity.getAdminEmail().equals(adminEmail) && entity.getPassword().equals(password)) {
					
				mailSendToAdmin(entity);
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy hh:mm aa");
				String formattedDate = dateFormat.format(new Date()).toString();
				
				entity.setLoginTime(formattedDate);
				adminRepo.save(entity);
				
				AdminEntity entity2 = adminRepo.findByAdminEmail(adminEmail);

				// coping entity to dto
				AdminDTO dto2 = new AdminDTO();
				BeanUtils.copyProperties(entity2, dto2);
				return dto2;
				} else {
					log.info("Service: invalid credential");
				}
			} else {
				log.info("Service: No matching record found by email");
			}
		} else {
			log.info("Service: email & password are null");
		}
		return null;
	}

	@Override
	public boolean adminParkingAcountCreate(AdminParkingEntity adminParkingEntity) {

		
			log.info("data does not exist in db, saving new record");	
		adminParkingRepo.save(adminParkingEntity);
	return true;
	}
	
	@Override
	public boolean saveAdminParkingDTO(AdminParkingDTO dto) {
		AdminParkingEntity	record=adminParkingRepo.findByLocationAndVehicleTypeAndEngineTypeAndClsAndTerm(dto.getLocation(), dto.getVehicleType(), dto.getEngineType(), dto.getClassification(), dto.getTerm());
		if (record != null) {
			log.info("data is already exist");
			return false;
		} else {
			log.info("data does not exist in db, saving new record");
			AdminParkingEntity entity = new AdminParkingEntity();
			BeanUtils.copyProperties(dto, entity);
			boolean saved = adminParkingRepo.save(entity) != null;
			if (saved) {
				log.info("Service: data saved");
				return true;
			}
			log.info("Service: data not saved");
			return false;
		}
	}

	@Override
	public AdminParkingDTO adminParkingFieldsExist(String location, String vehicleType, String engineType,
			String classification, String term) {
		log.info("running adminParkingFieldsExist()");
	AdminParkingEntity	record=adminParkingRepo.findByLocationAndVehicleTypeAndEngineTypeAndClsAndTerm(location, vehicleType, engineType, classification, term);
	if(record!=null) {
		log.info("data is already exist");
	AdminParkingDTO	dto=new AdminParkingDTO();
	BeanUtils.copyProperties(record, dto);
	return dto;
	}
	
	return null;
	}

	@Override
	public List<AdminParkingDTO> findByLocation(String location) {
	List<AdminParkingEntity>	findLocation=adminParkingRepo.findByLocation(location);
	if (!findLocation.isEmpty()) {
		List<AdminParkingDTO> dtoList = findLocation.stream().map(entity -> {
			AdminParkingDTO dto = new AdminParkingDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).collect(Collectors.toList());
		return dtoList;
	}
		return null;
	}
	
	@Override
	public void mailSendToUserAndParkingInfo(String email, String name, UserParkingDTO updto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("SignUp Confirmation");
		message.setText("Dear " + name + " " + ", You have been successfully Signed Up,\n"
				 + email + "\n "
				 +"You are registered successfully!\n"
				 + "Below is your parking details:\n"
				 + "Vehicle No.: "+updto.getVehicleNo()+"\n"
					+ "Location: "+updto.getLocation()+"\n"
					+ "Vehicle Type: "+updto.getVehicleType()+"\n"
					+ "Engine Type: "+updto.getEngineType()+"\n"
					+ "Classification: "+updto.getClassification()+"\n"
					+ "Term: "+updto.getTerm()+"\n"
					+ "Price: "+updto.getPrice()+"\n"
					+ "Discount: "+updto.getDiscount()+"\n"
					+ "Total Amount: "+updto.getTotalAmount()
						+ "\n\n\n\n\n\n "
						+ "\n "
						+"\n "
						+"\n "
						+"\n "
						+ "Thanks and Regards,\n" 
						+ " "
				+ "Rental_Parking_Team");
		javaMailSender.send(message);	
		
	}
	

	@Override
	public boolean saveUserAndUserParkingDate(UserDTO userDTO, UserParkingDTO userParkingDTO) {
		log.info("running saveUserAndUserParkingDate()");	
	UserEntity	record=userRepo.findByUserEmail(userDTO.getEmail());
		if(record==null) {
		userDTO.setCreatedBy(userDTO.getName());	
		userDTO.setCreatedDate(LocalDate.now());
		userDTO.setUpdatedBy(userDTO.getName());
		userDTO.setUpdatedDate(LocalDate.now());
		userDTO.setOtp("0");
		userDTO.setOtpCount(0);
		userDTO.setAcctStatus("Active");
		
		log.info("saveUserAndUserParkingDate: userDTO: " + userDTO);
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDTO, userEntity);
		userRepo.save(userEntity);
		
		UserEntity userByEmail=userRepo.findByUserEmail(userDTO.getEmail());
		
		log.info("userByEmail: "+userByEmail);
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
//		String formattedDate = dateFormat.format(new Date());
		userParkingDTO.setUserId(userByEmail.getId());
		userParkingDTO.setPayment("Pending");
		userParkingDTO.setCreatedDate(LocalDateTime.now());
		userParkingDTO.setUpdatedDate(LocalDateTime.now());
		userParkingDTO.setActive(true);
		
		UserParkingEntity upEntity = new UserParkingEntity();
		BeanUtils.copyProperties(userParkingDTO, upEntity);
		userParkingRepo.save(upEntity);
		mailSendToUserAndParkingInfo(userDTO.getEmail(), userDTO.getName(), userParkingDTO);
		return true;
		}
		
		return false;
	}

	

	@Override
	public UserEntity isUserEmailExist(String email) {
	UserEntity	userEmail=userRepo.findByUserEmail(email);
		return userEmail;
	}

	@Override
	public boolean sendOTPToUserEmail(String email, String name, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Login OTP");
		message.setText("Dear " + name + " " + ", You have been successfully Signed Up,\n"
				 + email + "\n "
				 +"Pease login throught this"+"\n"
				 +"One Time Password (OTP) : "+otp
				 
						+ "\n\n\n\n\n\n "
						+ "\n "
						+"\n "
						+"\n "
						+"\n "
						+ "Thanks and Regards,\n" 
						+ " "
				+ "Rental_Parking_Team");
		javaMailSender.send(message);	
		return true;
		
	}

	@Override
	public boolean genarateOTPToUser(String email) {
		
		log.info("running generateOtp()");
	String	otp=GenerateOTP.generateOtp();
	log.info("service: generateOtp: otp: " + otp);
	
UserEntity entity	=userRepo.findByUserEmail(email);
	entity.setUpdatedDate(LocalDate.now());
	entity.setOtp(otp);
	entity.setOtpCount(0);
	entity.setAcctStatus("Active");
	entity.setOtpExpiryTime(LocalTime.now().plusSeconds(120));
//    userRepo.save(entity);
//    sendOTPToUserEmail(email, entity.getName(), otp);
if(userRepo.save(entity)!=null && sendOTPToUserEmail(email, entity.getName(), otp)) {
	log.info("otp generated & sent to registered email");
	return true;
}else {
	log.info("otp not generated & sent to registered email");
	return false;
}
	
	}

	@Override
	public boolean validateOTP(String email, String otp) {
		log.info("running validateOTP()");
		UserEntity entity=userRepo.findByUserEmail(email);
	int	otpCount=entity.getOtpCount();
		if(entity.getAcctStatus().equals("Active")) {
			log.info("service: validateOTP(): acct is active");	
			if(entity.getOtp().equals(otp)) {
				log.info("valid otp");
				return true;
			} else {
				log.info("service: validateOTP(): invalid otp");
				otpCount++;
		
			if(otpCount<3) {
				log.info("service: validateOTP(): otp count is < 3");
				entity.setOtpCount(otpCount);
				userRepo.save(entity);
				log.info("invalid otp");
				return false;
			}
			else {
				log.info("service: validateOTP(): otp count is = 3");
				entity.setOtpCount(otpCount);
				entity.setAcctStatus("Blocked");
				userRepo.save(entity);
				log.info("Acccount is blocked");
				return false;
			}
		}
		}
		log.info("Acccount is blocked");
		return false;
	}

	@Override
	public Map<String, Long> findPamentDueDays(String email) {
		log.info("running findPamentDueDays()");
		UserEntity uEntity=userRepo.findByUserEmail(email);
		List<UserParkingEntity> upList=userParkingRepo.findAllByUserId(uEntity.getId());
		
		 List<UserParkingEntity> paymentPendingList=upList.stream().filter(e->e.isActive())
		.filter(e->e.getPayment().equals("Pending"))
		.collect(Collectors.toList());
		 log.info("findPamentDueDays(): paymentPendingList: " + paymentPendingList);
		if(!paymentPendingList.isEmpty()) {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
//			String formattedDate = dateFormat.format(new Date());
			
		Map<String, Long>	dueDaysMap=new LinkedHashMap<String, Long>();
		for(UserParkingEntity upEntity:paymentPendingList) {
		long	noOfDays=DateDifference.findDaysDifference(upEntity.getCreatedDate(),LocalDateTime.now());
			dueDaysMap.put(upEntity.getVehicleNo(),noOfDays);	
		}
		log.info("findPamentDueDays(): DueDays Map: " + dueDaysMap);
		return dueDaysMap;
		
		}
		log.info("findPamentDueDays(): no due");
		return null;
	}

	@Override
	public UserParkingDTO findByVehicalNumber(String vehicleNo) {
		log.info("running findByVehicleNo()");
		UserParkingEntity entity=userParkingRepo.findByVehicalNumber(vehicleNo);
		if(entity!=null) {
			UserParkingDTO dto=new UserParkingDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public boolean addUserParkingInfo(UserParkingDTO upDto, String email) {
		log.info("running addUserParkingInfo()");
		UserEntity entityByEmail=isUserEmailExist(email);
		if(entityByEmail!=null) {
			log.info("entityByEmail is not null");
			
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");
//			String formattedDate = dateFormat.format(new Date());
			
			upDto.setUserId(entityByEmail.getId());
			upDto.setPayment("pending");
			upDto.setCreatedDate(LocalDateTime.now());
			upDto.setUpdatedDate(LocalDateTime.now());
			upDto.setActive(true);
			
			UserParkingEntity upEntity = new UserParkingEntity();
			BeanUtils.copyProperties(upDto, upEntity);
			userParkingRepo.save(upEntity);
			mailSendToUserAndParkingInfo(email, entityByEmail.getName(), upDto);
			return true;
		}
		
		log.info("entityByEmail is not null");
		return false;
	}

	@Override
	public List<UserParkingDTO> findAllById(String email) {
		log.info("running findAllById()");
		UserEntity userEntity=userRepo.findByUserEmail(email);
		List<UserParkingEntity> upEntities=userParkingRepo.findAllByUserId(userEntity.getId());
		log.info("service: findAllById: upList: " + upEntities);
		if(!upEntities.isEmpty()) {
		List<UserParkingDTO> upDtos=upEntities.stream().map(entity->{
			UserParkingDTO upDto=new UserParkingDTO();
			BeanUtils.copyProperties(entity, upDto);
			return upDto;
		}).collect(Collectors.toList());
		return upDtos;	
		}
		return null;
	}

	@Override
	public boolean updateUserParkingInfo(UserParkingDTO upDto) {
		log.info("service: running updateUserParkingInfo()");
		log.info("service: running updateUserParkingInfo(): upDto: "+upDto);
		UserParkingEntity entity=userParkingRepo.findByVehicalNumber(upDto.getVehicleNo());
		if(entity!=null) {
			log.info("entity is not null: "+entity);
			entity.setLocation(upDto.getLocation());
			entity.setVehicleType(upDto.getVehicleType());
			entity.setEngineType(upDto.getEngineType());
			entity.setClassification(upDto.getClassification());
			entity.setTerm(upDto.getTerm());
			entity.setPrice(upDto.getPrice());
			entity.setDiscount(upDto.getDiscount());
			entity.setTotalAmount(upDto.getTotalAmount());
			entity.setUpdatedDate(LocalDateTime.now());
			
			if(upDto.getFileName()!=null)
			{
				entity.setFileName(upDto.getFileName());
				entity.setOriginalFileName(upDto.getOriginalFileName());
				entity.setContentType(upDto.getContentType());
			}
		UserParkingEntity	updated=userParkingRepo.save(entity);
		if(updated!=null) {
			log.info("service: updateUserParkingInfo(): updated user parking info");
			return true;
		}
		log.info("service: updateUserParkingInfo(): not updated user parking info");
		return false;
		}
		log.info("service: updateUserParkingInfo(): entity is null");
		return false;
	}

	@Override
	public boolean deleteUserParkingEntityByVehicleNo(String vehicleNo) {
		log.info("running deleteUserParkingEntityByVehicleNo()");
		 if(userParkingRepo.deleteUserParkingEntity(vehicleNo)!=null) {
				log.info("deleteUserParkingEntityByVehicleNo(): entity deleted");
			 return true;
		 } else {
					log.info("deleteUserParkingEntityByVehicleNo(): entity not deleted");
					return false;
			 }
	}

	@Override
	public boolean updatePayment(String vehicleNo) {
		log.info("running updatePayment()");
		UserParkingEntity entity=userParkingRepo.findByVehicalNumber(vehicleNo);
		entity.setPayment("paid");
		UserParkingEntity updated=userParkingRepo.save(entity);
		if(updated!=null) {
			 log.info("payment status updated");
			 return true;
		 }
		log.info("payment status not updated");
		return false;
	}

	@Override
	public List<UserParkingDTO> findAll() {
		log.info("running findAll()");
		List<UserParkingEntity> entityList=userParkingRepo.findAll();
		if(entityList!=null) {
		List<UserParkingDTO>	dtoList=entityList.stream().map(entity->{
			UserParkingDTO	dto=new UserParkingDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
			}).collect(Collectors.toList());
			return dtoList;
			}
		   return null;
	}
	

	
	
	
		}
		
	