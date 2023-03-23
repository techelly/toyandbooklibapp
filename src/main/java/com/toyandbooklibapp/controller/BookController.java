package com.toyandbooklibapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyandbooklibapp.exceptions.BookNotFoundException;
import com.toyandbooklibapp.model.Book;
import com.toyandbooklibapp.service.IBookService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/toyandbooklibapp")
public class BookController {
	@Autowired
	private IBookService bookService;

	@PostMapping("/book/save")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book newBook = bookService.saveBook(book);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(newBook, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/book/{bookId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer bookId) throws BookNotFoundException {
		Book book = bookService.viewBookById(bookId);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(book, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/book/all")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> books = bookService.viewAllBooks();
		ResponseEntity<List<Book>> responseEntity = new ResponseEntity<>(books, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@PutMapping("/book/update")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) throws BookNotFoundException{
		Book newBook = bookService.updateBook(book);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(newBook, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/book/deletebook/{bookId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Book> deleteBook(Integer bookId) throws BookNotFoundException{
		Book book = bookService.deleteBook(bookId);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(book, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/book/bytitle/{title}")
	@PreAuthorize("hasRole('USER') or hasRole('PARENT') or hasRole('ADMIN') or hasRole('CHILD')")
	public ResponseEntity<Book> viewBookByTitle(@PathVariable("title") String title) throws BookNotFoundException{
		Book book = bookService.viewBookByTitle(title);
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(book, HttpStatus.OK);
		return responseEntity;
	}

	
}
