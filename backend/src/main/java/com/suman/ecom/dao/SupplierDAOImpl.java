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

import com.suman.ecom.model.Supplier;

@Repository(value = "supplierDAO")
// @EnableTransactionManagement
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	Supplier supplier;

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;

	}

	@Transactional

	public boolean savOrUpdate(Supplier supplier) {
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			// s.saveOrUpdate(supplier);
			s.persist(supplier);
			System.out.println("adding supplier  impl");

			t.commit();

			// sessionFactory.getCurrentSession().save(supplier);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {

		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();

			// sessionFactory.getCurrentSession().delete(product);
			s.delete(supplier);
			System.out.println("deleete suppllier...in impl");

			t.commit();

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional

	public List<Supplier> list() {

		String hql = "from Supplier";
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		org.hibernate.Query query = s.createQuery(hql);
		List<Supplier> all = query.list();
		System.out.println("supplier list in impl");
		tx.commit();
		return all;
	}

	@Transactional

	public Supplier get(int id) {
		String hql = "from Supplier where supplier_id=" + id;

		// hibernate query

		Session s = sessionFactory.getCurrentSession();
		Transaction t = s.beginTransaction();

		Query query = s.createQuery(hql);

		// Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		// t.commit();
		if (list == null) {
			return null;

		} else {

			System.out.println("geeeet supplier in impl");

			return list.get(0);

		}

	}

	@Transactional
	public boolean update(Supplier supplier) {

		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(supplier);
			System.out.println("update supplier in impl");
			tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Supplier getByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Supplier where supplier_name" + "'" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = (List<Supplier>) query.list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/*
	 * Session s = sessionFactory.getCurrentSession(); Transaction tx =
	 * s.beginTransaction(); String hql =
	 * "from Supplier where supplier_name="+"'"+name+"'"; org.hibernate.Query
	 * query = s.createQuery(hql); List<Supplier> list=query.list();
	 * tx.commit(); if(list==null || list.isEmpty()) {return null;} else{
	 * System.out.println("getting supplier det. by name");
	 * 
	 * return list.get(0); }
	 * 
	 * }
	 */
}
