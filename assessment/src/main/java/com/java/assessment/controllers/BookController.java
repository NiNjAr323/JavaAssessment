package com.java.assessment.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.assessment.models.Book;
import com.java.assessment.services.BookService;

@Controller
//@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	private static Logger logger = LoggerFactory.getLogger(BookController.class);

	// bookService.count() return count,
	// it is used to check if 
	//bookService contains any member
	@GetMapping("/listpage")
	public String getListPage(Model model) {

		if (logger.isDebugEnabled()) {
			logger.debug("getListPage function from BookController was used");
		}

		if (bookService.count() != 0) {
			model.addAttribute("books", bookService.getBooks());
			return "listpage";
		} else {
			return "norecord";
		}

	}

	@GetMapping("/newrecord")
	public String getNewRecord(Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getNewRecord function from BookController was used");
		}
		model.addAttribute("books", bookService.getBooks());
		return "newrecord";
	}

	@GetMapping("/onebook")
	@ResponseBody
	public Optional<Book> getBookById(Long id, Model model) {
		if (logger.isDebugEnabled()) {
			logger.debug("getBookById function from BookController was used");
		}
		return bookService.getBookById(id);
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET })
	public String updateBook(Book book) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateBook function from BookController was used");
		}
		bookService.updateBook(book);
		return "redirect:/listpage";
	}

	@RequestMapping(value = "/addBook", method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET })
	public String addBook(Book book) {
		if (logger.isDebugEnabled()) {
			logger.debug("addBook function from BookController was used");
		}
		bookService.addBook(book);
		return "redirect:/listpage";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET })
	public String deleteBook(Long id) {
		bookService.deleteBookById(id);
		return "redirect:/listpage";
	}
}
