package it.degroup.ex1.models;

import java.util.Collection;

import org.springframework.stereotype.Service;

import it.degroup.ex1.models.Book;


public interface BookService {
	Collection<Book> getBooks();
	Book addBook(Book book);
}
