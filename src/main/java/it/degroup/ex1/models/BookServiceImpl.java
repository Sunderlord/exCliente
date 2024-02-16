package it.degroup.ex1.models;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	public List<Book> books=new ArrayList<Book>();

	public Collection<Book> getBooks() {
		return books;
	}

	public Book addBook(Book book) {
		books.add(book);
		return book;
	}

}
