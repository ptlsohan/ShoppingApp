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
		return null;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> searchProduct(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBook(Book b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Book b) {
		// TODO Auto-generated method stub
		return 0;
	}

}
