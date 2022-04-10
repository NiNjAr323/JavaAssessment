package com.java.assessment.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.assessment.models.Book;
import com.java.assessment.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	private static Logger logger = LoggerFactory.getLogger(BookService.class);

	public List<Book> getBooks() {
		if (logger.isDebugEnabled()) {
			logger.debug("getBooks function from BookService was used");
		}
		return (List<Book>) bookRepository.findAll();
	}

	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		if (logger.isDebugEnabled()) {
			logger.debug("addBook function from BookService was used");
		}
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}

	public long count() {
		if (logger.isDebugEnabled()) {
			logger.debug("count function from BookService was used");
		}
		return bookRepository.count();
	}

}
