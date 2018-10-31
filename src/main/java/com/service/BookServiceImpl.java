package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Book;
import com.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired BookRepository brep;
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return brep.getAllBook();
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		// TODO Auto-generated method stub
		return brep.getBookByCategory(category);
	}

	@Override
	public List<Book> searchProduct(String key) {
		// TODO Auto-generated method stub
		return brep.searchProduct(key);
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return brep.getBookById(id);
	}

	@Override
	public int updateBook(Book b) {
		// TODO Auto-generated method stub
		return brep.updateBook(b);
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return brep.deleteProduct(id);
	}

	@Override
	public int addProduct(Book b) {
		// TODO Auto-generated method stub
		return brep.addProduct(b);
	}

	@Override
	public long getTotalCount() {
		System.out.println("book tottal");
		return brep.getTotalCount();
	}

}
