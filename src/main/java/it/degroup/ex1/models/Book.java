package it.degroup.ex1.models;

import javax.persistence.*;

@Entity
@Table(name="Book")
public class Book {
	@Id
private String isbn;
	@Column
private String title;
	@Column
private String author;

public Book() {}

public Book(String isbn, String title, String author) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.author = author;
}

public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}


}
