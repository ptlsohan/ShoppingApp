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

@Repository
public class BookRepositoryImpl implements BookRepository {

	@Autowired SessionFactory sf;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBook() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> products = session.createQuery("from Book").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
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
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Book book = session.get(Book.class, id);
		tx.commit();
		session.close();
		return book;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Book> cr = cb.createQuery(Book.class);
		Root<Book> root = cr.from(Book.class);
		cr.where(cb.or(cb.like(root.get("name"),"%"+key+"%"),cb.like(root.get("companyName"),"%"+key+"%")));
		
		
		Query query = session.createQuery(cr);
		List<Book> results = query.getResultList();
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public long getTotalCount() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Book> root = cr.from(Book.class);
		cr.select(cb.count(root));
		

		Query query = session.createQuery(cr);
		
		Long result = (Long) query.getSingleResult();
		
		System.out.println("book tottal"+result);
		tx.commit();
		session.close();
		return result;
	}

}
