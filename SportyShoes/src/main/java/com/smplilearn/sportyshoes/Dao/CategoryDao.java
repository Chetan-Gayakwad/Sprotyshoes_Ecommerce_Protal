package com.smplilearn.sportyshoes.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.simplilearn.sportyshoes.servlet.registerServlet;
import com.smplilearn.sportyshoes.entities.Category;

public class CategoryDao {

	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public int savaCategory(Category cat) {

		Session session = this.factory.openSession();
		Transaction transaction = session.beginTransaction();
		int catId = (Integer) session.save(cat);
		transaction.commit();
		session.close();
		return catId;
	}

	public List<Category> getCategory() {

		Session s = this.factory.openSession();
		Query query = s.createQuery("from Category");

		List<Category> list = query.list();
		return list;

	}

	public Category getCategoryById(int cId) {
		Category cat = null;
		try {
			Session session = this.factory.openSession();
			cat = session.get(Category.class, cId);

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cat;
	}

}
