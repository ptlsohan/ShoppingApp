package com.repository;

import java.util.List;

import com.dto.Book;




public interface BookRepository {
	List<Book> getAllBook();
	List<Book> getBookByCategory(String category);
	List<Book> searchProduct(String key);
	Book  getBookById(int id);
	int updateBook(Book b );
	int deleteProduct(int id);
	int addProduct(Book b );
	long getTotalCount();
	
}
