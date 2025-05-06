package com.priyanka.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.priyanka.dto.JavaBookDetailsDto;
import com.priyanka.entity.JavaBookDetailsEntity;
import com.priyanka.repo.JavaBookRepo;

@Service
public class JavaBookServiceImpl implements JavaBookService{

	@Autowired
	private JavaBookRepo javaBookRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
   public	JavaBookServiceImpl() {
	   System.out.println("Acount created"+this.getClass().getSimpleName());
   }
	
	@Override
	public void acountCreateJavaBook(JavaBookDetailsEntity javaBookDetails) {
		System.out.println("Books account is created");
		String encryption=passwordEncoder.encode(javaBookDetails.getPassword());
	javaBookDetails.setPassword(encryption);
		javaBookRepo.save(javaBookDetails);
		System.out.println("Save all the books"+javaBookDetails);
	}

	@Override
	public JavaBookDetailsEntity getFirstEmail(String email) {
		
		 return  javaBookRepo.findByEmail(email);
	}
	
//	@Override
//	public JavaBookDetailsDto saveDto(String email) {
//		 JavaBookDetailsEntity bookEntity=javaBookRepo.findByEmail(email);
//	JavaBookDetailsDto	dto=new JavaBookDetailsDto();
//		 BeanUtils.copyProperties(bookEntity, dto);
//		 return dto;
//	}

	@Override
	public List<JavaBookDetailsDto> getAllBookDetails() {
		List<JavaBookDetailsEntity>bookEntity= javaBookRepo.findAll();
	if(bookEntity!=null) {
		List<JavaBookDetailsDto>	dtoList=bookEntity.stream().map(entity->{
			JavaBookDetailsDto	dto=new JavaBookDetailsDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
			}).collect(Collectors.toList());
			return dtoList;
	}
	return null;
	}

	List<JavaBookDetailsDto>	allBooks=new ArrayList<JavaBookDetailsDto>();
	@Override
	public void deleteBooks(Integer contactNumber) {
	
	allBooks.removeIf(x->x.getContactNumber().equals(contactNumber));
	System.out.println("Delete based on contact number"+ allBooks);	
	}

	@Override
	public JavaBookDetailsDto editBooks(Integer contactNumber) {
		
	JavaBookDetailsDto editBooks=allBooks.stream().filter(x->x.getContactNumber().equals(contactNumber)).findAny().orElse(null);	
  JavaBookDetailsEntity	bookEntity=new JavaBookDetailsEntity();
  BeanUtils.copyProperties(editBooks, bookEntity);
	return editBooks;
	}

	@Override
	public void updateBooks(JavaBookDetailsDto javaBookDetailsDto) {
		int dto =IntStream.range(0, allBooks.size())
				.filter(i->allBooks.get(i).getContactNumber()
						.equals(javaBookDetailsDto.getContactNumber()))
				.findFirst().orElse(-1);
		allBooks.set(dto, javaBookDetailsDto);
	JavaBookDetailsEntity	entity=new JavaBookDetailsEntity();
	BeanUtils.copyProperties(dto, entity);
	}

	
	
}



