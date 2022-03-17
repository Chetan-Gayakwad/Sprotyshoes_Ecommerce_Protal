package com.smplilearn.sportyshoes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.smplilearn.sportyshoes.entities.Product;

import net.bytebuddy.asm.Advice.Return;

public class ProductDao {

	private SessionFactory factory;

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	};

	public boolean saveProduct(Product product) {

		boolean f = false;
		Session session = this.factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(product);

		tx.commit();
		session.close();
		return f = true;
	}

	public List<Product> getAllProduct() {
		Session session = this.factory.openSession();

		Query query = session.createQuery("from Product");
		List<Product> list = query.list();
		return list;
	}

	public List<Product> getAllProductById(int cid){
		Session session = this.factory.openSession();
		
		Query query = session.createQuery("from Product as p where p.category.categoryId =: id");
		query.setParameter("id", cid);
		List<Product> list= query.list();
		return list;
	}

}
