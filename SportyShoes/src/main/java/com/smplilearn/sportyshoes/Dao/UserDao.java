package com.smplilearn.sportyshoes.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.smplilearn.sportyshoes.entities.User;

public class UserDao {

	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public User getUserByemailAndpassword(String email, String password) {

		User user = null;

		try {
			
			String querry ="from User where UserEmail =:e and UserPassword =:p";
			Session session = this.factory.openSession();
			
			Query q = session.createQuery(querry);
			q.setParameter("e", email);
			q.setParameter("p", password);
			user= (User)q.uniqueResult();
			
			
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

}
