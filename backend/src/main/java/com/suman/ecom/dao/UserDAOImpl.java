package com.suman.ecom.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suman.ecom.model.User;

@Repository(value = "userDAO")
// @EnableTransactionManagement

public class UserDAOImpl implements UserDAO {

	@Autowired
	User user;

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean isValidate(String name, String pass) {

		if (name.equals("sa") && pass.equals("sa")) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional

	public boolean saveOrUpdate(User user) {
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(user);
			t.commit();
			// sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public User get(String name) {
		System.out.println("inside get method");
		Session s = sessionFactory.getCurrentSession();
		Transaction t = s.beginTransaction();
		// emailid col in tab .name is string
		String str = "From User where emailid='" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(str);
		List<User> ulist = query.list();

		if ((ulist != null) && ulist.isEmpty()) {
			System.out.println("fetch from user");
			t.commit();

		}

		return ulist.get(0);
	}

	@Transactional
	public List<User> checksignin(String id) {
		String hql = "from User user_id where emailid=" + id;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<User> all = query.list();
		tx.commit();
		return all;
	}

	@Transactional
	public User get(int id) {

		// select * from user where user_id=selected id
		String hql = "from User where user_id=" + id;

		// hibernate query

		Session s = sessionFactory.getCurrentSession();
		Transaction t = s.beginTransaction();

		Query query = s.createQuery(hql);

		// Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		// t.commit();
		if (list == null) {
			return null;

		} else {

			System.out.println("geeeet user");

			return list.get(0);

		}

	}

	// ...................

	@Transactional
	public User getbyid(int id) {

		try {
			String hql = "from User where user_id=" +id;
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<User> list = query.list();
			tx.commit();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
