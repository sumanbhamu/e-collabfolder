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

import com.suman.ecom.model.Category;

@Repository("categoryDAO")
// @EnableTransactionManagement

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	Category category;

	/* @Autowired */
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;

	}

	@Transactional

	public boolean save(Category category) {
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(category);
			t.commit();

			// sessionFactory.getCurrentSession().saveOrUpdate(category);

			System.out.println("adding, saving categor   impl");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional

	public Category get(int id) {

		String hql = "from Category where cat_id=" + "'" + id + "'";
		Session s = sessionFactory.getCurrentSession();
		Transaction t = s.beginTransaction();

		Query query = s.createQuery(hql);

		// Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		// t.commit();
		if (list == null) {
			return null;

		} else {

			System.out.println("geeeet category");

			return list.get(0);

		}

	}

	@Transactional

	public List<Category> list() {

		String hql = "from Category";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Category> all = query.list();
		tx.commit();
		return all;
	}

	public boolean delete(Category category) {
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();

			// sessionFactory.getCurrentSession().delete(category);
			s.delete(category);
			System.out.println("deleete category");

			t.commit();

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(Category category) {

		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(category);
			System.out.println("update category in impl");
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}