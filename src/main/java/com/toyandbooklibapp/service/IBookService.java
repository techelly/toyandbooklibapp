package com.toyandbooklibapp.service;

import java.util.List;

import com.toyandbooklibapp.exceptions.BookNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.Book;

public interface IBookService {
	public Book saveBook(Book book);

	public Book updateBook(Book book) throws BookNotFoundException;

	public Book deleteBook(Integer bookId) throws BookNotFoundException;

	public Book viewBookById(Integer bookId) throws BookNotFoundException;

	public Book viewBookByTitle(String title) throws BookNotFoundException;

	public List<Book> viewAllBooks()throws ResourceNotFoundException;

}
