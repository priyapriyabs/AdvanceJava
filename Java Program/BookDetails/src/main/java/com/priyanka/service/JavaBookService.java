package com.priyanka.service;

import java.util.List;

import com.priyanka.dto.JavaBookDetailsDto;
import com.priyanka.entity.JavaBookDetailsEntity;

public interface JavaBookService {

  void	acountCreateJavaBook(JavaBookDetailsEntity javaBookDetails);
  
  JavaBookDetailsEntity getFirstEmail(String email);
  
//  public boolean saveBookDTO(JavaBookDetailsDto dto);

List<JavaBookDetailsDto> getAllBookDetails();

public void deleteBooks(Integer contactNumber);

JavaBookDetailsDto editBooks(Integer contactNumber);

void updateBooks(JavaBookDetailsDto javaBookDetailsDto);
}
