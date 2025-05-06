package com.priyanka.service;

import com.priyanka.dto.ImageUpdateDTO;

public interface ImageUploadService {

	void acountCreateImgDto(ImageUpdateDTO imageUpdateDTO);
	
ImageUpdateDTO	getImgDetailsByUserId(int userId);

//ImageUpdateDTO deactivateAllImagesForUser(int userId);

}
