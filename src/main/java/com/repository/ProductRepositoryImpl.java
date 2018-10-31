package com.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	
	
	@Autowired SessionFactory sf;

	@Autowired HibernateTemplate template;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Product> products = session.createQuery("from Product").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByCategory(String category) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Product> products = session.createQuery("from Product where category='"+category+"'").getResultList();
		tx.commit();
		session.close();
		return products;
	}

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public Product getProductById(int id) {
//		Session session = sf.openSession();
//		Transaction tx = session.beginTransaction();
		Product p=template.get(Product.class, id);
//		tx.commit();
//		session.close();
		return p;
	}

	@Override
	public int updateProduct(int id,int qty) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String sql="update Product set quantity="+qty+" where id="+id;
		Query q=session.createNativeQuery(sql);
		q.executeUpdate();
		tx.commit();
		session.close();
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchProduct(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
		Root<Product> root = cr.from(Product.class);
		
		cr.where(cb.or(cb.like(root.get("name"),"%"+key+"%"),cb.like(root.get("companyName"),"%"+key+"%")));
		
		Query query = session.createQuery(cr);
		
		List<Product> results = query.getResultList();
		
		
		
		tx.commit();
		session.close();
		return results;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> searchApi(String key) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
		Root<Product> root = cr.from(Product.class);
		
		cr.where(cb.or(cb.like(root.get("name"),"%"+key+"%"),cb.like(root.get("companyName"),"%"+key+"%")));
		
		Query query = session.createQuery(cr);
		
		List<Product> results = query.getResultList();
		
		
		tx.commit();
		session.close();
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByPage(String category, int s) {
		 s=s*6;
		Session session = sf.openSession();
		Query query=session.createQuery("from Product where category='"+category+"'");
		
		query.setFirstResult(s); 
		query.setMaxResults(6);
		List<Product> list=query.getResultList();
		System.out.println(list);
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProductByPage(int i) {
		 i=i*6;
			Session session = sf.openSession();
			Query query=session.createQuery("from Product");
			
			query.setFirstResult(i); 
			query.setMaxResults(6);
			List<Product> list=query.getResultList();
			System.out.println(list);
			session.close();
			return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getQty(int id) {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
		String sql="from Product where id="+id; 
		Optional<Product> product=  session.createQuery(sql).uniqueResultOptional();
		product.orElse(new Product());
		int ret=product.get().getQuantity();
		System.out.println("qty in rep"+ret);
		tx.commit();
		session.close();
		return ret;
	}

	@Override
	public long getTotalCount() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Product> root = cr.from(Product.class);
		cr.select(cb.count(root));
		

		Query query = session.createQuery(cr);
		
		Long result = (Long) query.getSingleResult();
		
		
		tx.commit();
		session.close();
		return result;
	}
	
	@Override
	@Transactional
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		template.update(p);
	}

	

}
