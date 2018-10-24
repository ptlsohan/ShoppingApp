package com.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Book;
import com.dto.Laptop;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@Autowired SessionFactory sf;
	
	
	@Override
	public List<Book> getAllBook() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> products = session.createQuery("from Book").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> products = session.createQuery("from Book where category='"+category+"'").getResultList();
		tx.commit();
		session.close();
		return products;
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

	@Override
	public List<Book> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Book> cr = cb.createQuery(Book.class);
		Root<Book> root = cr.from(Book.class);
		cr.where(cb.like(root.get("name"),"%"+key+"%"));
		
		Query query = session.createQuery(cr);
		List<Book> results = query.getResultList();
		return results;
	}

}
