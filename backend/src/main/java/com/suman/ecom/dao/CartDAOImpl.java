package com.suman.ecom.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.suman.ecom.model.Cart;

public class CartDAOImpl implements CartDAO {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
		
	}

	
	@Transactional
	public boolean save(Cart cart) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(cart);
			t.commit();
			//sessionFactory.getCurrentSession().save(cart);
			System.out.println("saving into cart...impl");
			
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Cart cart) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(cart);
			tx.commit();
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Cart cart) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.delete(cart);
			tx.commit();
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Cart getbyid(int id) {
		try {
			String hql = "from Cart where user_id=" + id;
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> list = query.list();
			tx.commit();
			if (list == null){
				return null;}
			else {
				System.out.println("getting by id product.......in impl");

				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
@Transactional
	public int totalproducts(int id) {
		try {
			String hql = "from Cart where user_id=" +id;
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			int k = 0;
			for (Cart temp : all) {
				k = k + 1;
			}
			System.out.println("total products in ......impl");
			return k;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int totalprice(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	public List<Cart> list() {
		try {
			String hql = "from Cart";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}


	public List<Cart> listcartproducts(int id) {
		try {
			String hql = "from Cart where user_id=" +id;
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			System.out.println("listing cart product.......in impl");
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
