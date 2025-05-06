package com.priyanka.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.priyanka.dto.JavaBookDetailsDto;
import com.priyanka.entity.JavaBookDetailsEntity;
import com.priyanka.service.JavaBookServiceImpl;

@Controller
public class JavaBookController {

	@Autowired
	private JavaBookServiceImpl javaBookServiceImpl;

	public JavaBookController() {
		System.out.println("Running============>" + this.getClass().getSimpleName());
	}

	@PostConstruct
	public void init() {
		System.out.println("Application runns in init method===============>");
	}

	@RequestMapping("/javaBookDisplay")
	public String goToBookDetails() {
		return "BookDetails";
	}

	List<JavaBookDetailsEntity> allBooks=new ArrayList<JavaBookDetailsEntity>();
	@RequestMapping("/bookSave")
	public String javaBookInfo(@ModelAttribute("saveBooks") JavaBookDetailsEntity javaBookDetails, Model model) {
		System.out.println("Running controller for save book information=============>");
//		javaBookServiceImpl.acountCreateJavaBook(javaBookDetails);
		allBooks.add(javaBookDetails);
		model.addAttribute("myBooks", javaBookDetails);
		System.out.println("Books are saved===============>" + allBooks);
		return "BooksInfo";

	}

	@RequestMapping("/viewBooks")
	public String viewBooks(Model model) {
		System.out.println("Ruuning display book details===============>");
		List<JavaBookDetailsDto> allBooks = javaBookServiceImpl.getAllBookDetails();
		model.addAttribute("allbooks", allBooks);
		System.out.println("View Book Details=============>" + allBooks);
		return "JavaBooks";
	}

	@RequestMapping("/deleteadmin")
	public String deleteBook(@RequestParam Integer contactNumber,Model model) {
		javaBookServiceImpl.deleteBooks(contactNumber);
		List<JavaBookDetailsDto> allBooks = javaBookServiceImpl.getAllBookDetails();
		model.addAttribute("allbooks", allBooks);
		return "JavaBooks";
	}
	
	@RequestMapping("/editadmin")
	public String editBook(@RequestParam Integer contactNumber, Model model) {
	JavaBookDetailsDto	bookEdit=javaBookServiceImpl.editBooks(contactNumber);
		model.addAttribute("editboos", bookEdit);
		return "EditBooks";
	}
	
	@RequestMapping("/update")
	public String updateBook(@ModelAttribute("bookDetails") JavaBookDetailsDto javaBookDetailsDto,Model model) {
	javaBookServiceImpl.updateBooks(javaBookDetailsDto);
		model.addAttribute("allbooks", allBooks);
		return "JavaBooks";
	}
	
	@RequestMapping("/home")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/logout")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "index";
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Application closed================>");
	}

}
