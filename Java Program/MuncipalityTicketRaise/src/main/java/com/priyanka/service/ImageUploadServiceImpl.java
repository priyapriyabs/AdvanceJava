package com.priyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.dto.ImageUpdateDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.ImageUploadRepo;
import com.priyanka.repository.UserSignUpDTORepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImageUploadServiceImpl implements ImageUploadService {

	@Autowired
	private ImageUploadRepo imageUploadRepo;
	
	@Autowired
	private UserSignUpDTORepo upDTORepo;

	@Override
	public void acountCreateImgDto(ImageUpdateDTO imageUpdateDTO) {
		
		imageUploadRepo.save(imageUpdateDTO);
	}

	@Override
	public ImageUpdateDTO getImgDetailsByUserId(int userId) {
		
		return imageUploadRepo.findByUserId(userId);
	}
	
//	@Override
//	public ImageUpdateDTO deactivateAllImagesForUser(int userId) {
//		SignUpDTO usermail=new SignUpDTO();
//		SignUpDTO user=upDTORepo.findByUserEmail(usermail.getEmail());
//		ImageUpdateDTO imgDto=imageUploadRepo.deactivateAllImagesForUser(user.getId());
//		if(imgDto==null) {
//			imgDto.setStatus("No");
//			imageUploadRepo.save(imgDto);
//			return imgDto;
//		}
//		return null;
		
//	}





}
