package com.toyandbooklibapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyandbooklibapp.entities.BookEntity;
import com.toyandbooklibapp.exceptions.BookNotFoundException;
import com.toyandbooklibapp.exceptions.ResourceNotFoundException;
import com.toyandbooklibapp.model.Book;
import com.toyandbooklibapp.repositories.IBookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		// convert book model to book entity

		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);

		BookEntity newBookEntity = bookRepository.save(bookEntity);
		// covert book entity to book model

		Book newBook = new Book();
		BeanUtils.copyProperties(newBookEntity, newBook);

		return newBook;
	}

	@Override
	public Book viewBookById(Integer bookId) throws BookNotFoundException {
		Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException("Book not existing with id:" + bookId);
		}
		BookEntity bookEntity = optionalBook.get();
		// convert book entity to book model
		Book book = new Book();
		BeanUtils.copyProperties(bookEntity, book);
		return book;
	}

	@Override
	public Book updateBook(Book book) throws BookNotFoundException {

		Optional<BookEntity> optionalBook = bookRepository.findById(book.getBookId());
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException("Book not existing with id:" + book.getBookId());
		}
		BookEntity bookEntity = optionalBook.get();
		// convert book entity to book model
		Book newBook = new Book();
		BeanUtils.copyProperties(bookEntity, newBook);

		BookEntity newBookEntity = bookRepository.save(bookEntity);
		// convert book entity to book model
		Book nBook = new Book();
		BeanUtils.copyProperties(newBookEntity, nBook);
		return nBook;
	}

	@Override
	public Book deleteBook(Integer bookId) throws BookNotFoundException {
		Optional<BookEntity> optionalBook = bookRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException("Book not existing with id:" + bookId);
		}
		BookEntity bookEntity = optionalBook.get();
		bookRepository.delete(bookEntity);
		// convert book entity to book model
		Book book = new Book();
		BeanUtils.copyProperties(bookEntity, book);
		return book;
	}

	@Override
	public Book viewBookByTitle(String title) throws BookNotFoundException {
		Optional<BookEntity> optionalBook = bookRepository.findByTitle(title);
		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException("Book not existing with id:" + title);
		}
		BookEntity bookEntity = optionalBook.get();
		// convert book entity to book model
		Book book = new Book();
		BeanUtils.copyProperties(bookEntity, book);
		return book;
	}

	@Override
	public List<Book> viewAllBooks() throws ResourceNotFoundException {
		List<BookEntity> bookEntities = (List<BookEntity>) bookRepository.findAll();
		if (!bookEntities.isEmpty()) {
			// convert book entity list to book list
			List<Book> books = new ArrayList<>();
			bookEntities.forEach(pentity -> {
				Book book = new Book();
				BeanUtils.copyProperties(pentity, book);
				books.add(book);
			});
			return books;
		} else {
			throw new ResourceNotFoundException("No books found");
		}

	}

}
