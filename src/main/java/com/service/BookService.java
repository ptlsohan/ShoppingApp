package com.service;

import java.util.List;

import com.dto.Book;
import com.dto.Laptop;

public interface BookService {
	List<Book> getAllBook();
	List<Book> getBookByCategory(String category);
	List<Book> searchProduct(String key);
	Book  getBookById(int id);
	int updateBook(Book b );
	int deleteProduct(int id);
	int addProduct(Book b );
}
