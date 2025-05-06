package com.priyanka.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.priyanka.dto.ImageUpdateDTO;
import com.priyanka.dto.SignUpDTO;
import com.priyanka.repository.UserSignUpDTORepo;
import com.priyanka.service.EditUserInfoServiceImpl;
import com.priyanka.service.ImageUploadServiceImpl;
import com.priyanka.service.UserSignUpServiceImpl;
import com.priyanka.util.FileConstants;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileUploadController {

	 
	
	@Autowired
	private UserSignUpServiceImpl upServiceImpl;

	@Autowired
	private EditUserInfoServiceImpl editUserInfoServiceImpl;

	@Autowired
	private ImageUploadServiceImpl imageUploadServiceImpl;
	
	@Autowired
	private UserSignUpDTORepo upDTORepo;

	public FileUploadController() {
		log.info("acount create: "+this.getClass().getSimpleName());
	}

@PostMapping("editProfile")
	public String StringuploadFile(@RequestParam("file") MultipartFile multipartFile,SignUpDTO signUpDTO,HttpSession session,Model model) {
		if(multipartFile==null) {
			 model.addAttribute("message", "Please select a file to upload");
	            return "ProfileEdit";
		}
		try {
			String originalFilename=multipartFile.getOriginalFilename();
			String newFilename=signUpDTO.getEmail()+"_"+originalFilename;
			Path path=Paths.get(FileConstants.UPLOAD_DIR, newFilename);
			Files.write(path,multipartFile.getBytes());
			signUpDTO.setProfileImage(newFilename);
			
		SignUpDTO	userEmail=upServiceImpl.findByUserEmail(signUpDTO.getEmail());
		if(userEmail==null) {
			  model.addAttribute("message", "User not found.");
              return "ProfileEdit";
		}
		
//		imageUploadServiceImpl.deactivateAllImagesForUser(userEmail.getId());
		 ImageUpdateDTO imageDTO = new ImageUpdateDTO();
		 imageDTO.setImageName(newFilename);
         imageDTO.setImageType(multipartFile.getContentType());
         imageDTO.setImageSize(multipartFile.getSize());
         imageDTO.setUserId(userEmail.getId());
         imageDTO.setCreatedAt(LocalDateTime.now());
         imageDTO.setCreatedBy(signUpDTO.getEmail());
         imageDTO.setModifiedAt(LocalDateTime.now());
         imageDTO.setModifiedBy(signUpDTO.getEmail());
         imageDTO.setStatus("Yes");
         imageUploadServiceImpl.acountCreateImgDto(imageDTO);
         userEmail.setProfileImage(newFilename);
         upDTORepo.save(userEmail);
         
         signUpDTO.setProfileImage(newFilename);
        SignUpDTO updateUser=editUserInfoServiceImpl.updateUserProfile(signUpDTO.getEmail(), signUpDTO);

        if (updateUser != null) {
            model.addAttribute("message", "Profile updated successfully!");
          return "Home";
        } else {
            model.addAttribute("message", "Profile update failed. User not found.");
        }
        String imageUrl = "/images/" + newFilename;
        session.setAttribute("profileImage", imageUrl);

        model.addAttribute("dto", signUpDTO);
        model.addAttribute("image", imageDTO);

		} catch (IOException e) {
            model.addAttribute("message", "File upload failed: " + e.getMessage());
		}

		 return "ProfileEdit";
		
	}

//@GetMapping("/showFile")
//public void showFile(String profileImage, HttpServletResponse resp) throws IOException {
//	log.info("running showFile()");
//	File physicalFile = new File(FileConstants.UPLOAD_DIR+profileImage); // STEP 1: GET ref of the file, by
//																				// name passed
//	// STEP2 : set content type
//	OutputStream outputStream = resp.getOutputStream(); // STEP 3: write file as Bytes to response
//	FileInputStream inputStream = new FileInputStream(physicalFile);
//	byte[] buffer = new byte[4096];
//	int length;
//	while ((length = inputStream.read(buffer)) > 0) {
//		outputStream.write(buffer, 0, length);
//	}
//	inputStream.close();
//	outputStream.flush();
//}



}
