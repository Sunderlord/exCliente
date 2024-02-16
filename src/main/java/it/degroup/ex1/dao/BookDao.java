package it.degroup.ex1.dao;

import it.degroup.ex1.models.Book;

import java.util.List;

public interface BookDao {
    public List<Book> findAllBook();
    public Book addBook(Book book);
    public Book findByName(String name);
}
