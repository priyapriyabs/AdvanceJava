package com.priyanka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.priyanka.dto.AdminParkingDTO;
import com.priyanka.dto.UserParkingDTO;
import com.priyanka.entity.UserEntity;
import com.priyanka.service.ParkingServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController // this must be included for ajax to be worked
@RequestMapping("/")
@EnableWebMvc // this must be included for ajax to be worked
@Slf4j
public class ParkingAjaxController {

	@Autowired
	private ParkingServiceImpl parkingServiceImpl;
	
	public ParkingAjaxController() {
		log.info("Created: " + getClass().getSimpleName());
	}
	
	@GetMapping(value = "/validateFields/{location}/{vehicleType}/{engineType}/{classification}/{term}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateFields(@PathVariable String location, @PathVariable String vehicleType,
			@PathVariable String engineType, @PathVariable String classification, @PathVariable String term,
			Model model) {
	log.info("running validateFields()");
           AdminParkingDTO dto=parkingServiceImpl.adminParkingFieldsExist(location, vehicleType, engineType, classification, term);
           System.out.println(dto);
           if (dto!=null) {
   			return "Data is already exist";
   		}
   		return "";
	}
	
	@GetMapping(value = "/validateEmail/{email}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateEmail(@PathVariable String email) {
		log.info("running validateFields()");
		UserEntity userEmail=parkingServiceImpl.isUserEmailExist(email);
		if(userEmail!=null) {
			return "Email is already registered, please login ";
			
		}
		else {
			return "";
		}
	}

	@GetMapping(value = "/getPriceAndDiscount/{location}/{vehicleType}/{engineType}/{classification}/{term}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminParkingDTO getPriceAndDiscount(@PathVariable String location, @PathVariable String vehicleType,
			@PathVariable String engineType, @PathVariable String classification, @PathVariable String term,
			Model model) {
		log.info("running validateFields()");
		AdminParkingDTO dto = parkingServiceImpl.adminParkingFieldsExist(location, vehicleType, engineType, classification, term);
		System.out.println(dto);
		if (dto!=null) {
			return dto;
		}
		return null;
	}

	@GetMapping(value = "/validateEmailForOPT/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateEmailForOPT(@PathVariable String email) {
		log.info("running validateEmailForOPT()");
		log.info("Ajax Controller: validateEmailForOPT: Email: "+email);
		UserEntity exist = parkingServiceImpl.isUserEmailExist(email);
		if (exist!=null) {
			log.info("Ajax Controller: validateEmailForOPT: isUserExist: "+exist);
			return "";
		}else {
			log.info("Ajax Controller: validateEmailForOPT: isUserExist: "+exist);
		return "*Not a registered mail-id";
		}
	}

	@PostMapping(value = "/validateOTP/{email}/{otp}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateOTP(@PathVariable String email, @PathVariable String otp) {
//	@PostMapping(value = "/validateOTP/{otp}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public String validateOTP(@PathVariable int otp) {
		log.info("AjaxController: running validateOTP()");
		log.info("AjaxController: running validateOTP(): email & otp from UI: "+email+", "+otp);
		UserEntity dto = parkingServiceImpl.isUserEmailExist(email);
		if (dto.getOtp().equals(otp)) {
			return "";
		}
		return "*Invalid OTP";
	}
	
	@GetMapping(value = "/validateVehicleNo/{vehicleNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String validateVehicleNo(@PathVariable String vehicleNo) {
		log.info("running validateVehicleNo()");
		UserParkingDTO dto = parkingServiceImpl.findByVehicalNumber(vehicleNo);
		if (dto!=null) {
			return "*This vehicle is already parked";
		}
		return "";
	}
	
}
	