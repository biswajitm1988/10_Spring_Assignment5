package com.fsd.spring.dao;

import com.fsd.spring.entity.Book;
import com.fsd.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

	@Autowired
	private BookRepository bookRepository;

	public boolean addBook(Book newBook) throws Exception {
		bookRepository.save(newBook);
		return true;
	}

	public List<Book> getAllBooks() throws Exception {
		List<Book> bookList = bookRepository.findAll();
		return bookList;
	}

	public List<Book> searchForBooks(String bookTitle) throws Exception {
		List<Book> bookList = bookRepository.findByTitleContaining(bookTitle);
		return bookList;
	}

	public int deleteBook(String bookTitle) throws Exception {
		int results = bookRepository.deleteBooksByTitleContaining(bookTitle);
		return results;
	}
}
