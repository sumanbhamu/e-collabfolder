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

import com.suman.ecom.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	Product product;

	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean savOrUpdate(Product product) {
		try {

			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			System.out.println("saving product");
			s.saveOrUpdate(product);
			t.commit();

			// sessionFactory.getCurrentSession().save(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// @Transactional
	public boolean delete(Product product) {

		try {

			
			  Session s = sessionFactory.getCurrentSession(); Transaction t =
			  s.beginTransaction();
			 
			//sessionFactory.getCurrentSession().delete(product);
			 s.delete(product);
			System.out.println("deleete product");

			 t.commit();

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	// retrieving list of product
	public List<Product> list() {
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		// tx.commit();

		// createCriteria is a depricated method(it helps in getting products
		// list based on condition)
		List<Product> list = s.createCriteria(Product.class).list();
		System.out.println("list ttt product");

		return list;
	}

	@Transactional
	public Product get(int id) {

		// select * from product where prod_id=selected id
		String hql = "from Product where prod_id=" + id;

		// hibernate query
		
		  Session s = sessionFactory.getCurrentSession(); Transaction t =
		  s.beginTransaction();
		 
		 Query query =s.createQuery(hql);
		 
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		//t.commit();
		if (list == null) {
			return null;

		} else {

			System.out.println("geeeet product");

			return list.get(0);

		}

	}

	
	/*/////////////////////////////////////////////
*/
	/*@Transactional
	public Product getid(int id) {

		// select * from product where prod_id=selected id
		String hql = "from Product quantity where prod_id=" + id;

		 Session s = sessionFactory.getCurrentSession(); Transaction t =
		  s.beginTransaction();
		 
		 Query query =s.createQuery(hql);
		 
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		//t.commit();
		if (list == null) {
			return null;

		} else {

			System.out.println("geeeet product");

			return list.get(0);

		}

	}
*/
}