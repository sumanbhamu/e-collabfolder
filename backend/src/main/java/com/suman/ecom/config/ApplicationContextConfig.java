package com.suman.ecom.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.suman.ecom.dao.CategoryDAO;
import com.suman.ecom.dao.CategoryDAOImpl;
import com.suman.ecom.dao.ProductDAO;
import com.suman.ecom.dao.ProductDAOImpl;
import com.suman.ecom.dao.SupplierDAO;
import com.suman.ecom.dao.SupplierDAOImpl;
import com.suman.ecom.dao.UserDAO;
import com.suman.ecom.dao.UserDAOImpl;
import com.suman.ecom.model.Cart;
import com.suman.ecom.model.Category;
import com.suman.ecom.model.Product;
import com.suman.ecom.model.Supplier;
import com.suman.ecom.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/suman");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("data source");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		// treat every session as a thread
		properties.put("hibernate.current_session_context_class", "thread");
		System.out.println("hbernate properties");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		 sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Cart.class);

		 sessionBuilder.addAnnotatedClass(Category.class);
		 sessionBuilder.addAnnotatedClass(Supplier.class);

		System.out.println("session factory ");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("transaction ");
		return transactionManager;
	}

	// User
	
	  @Autowired
	  
	  @Bean(name = "userDAO") public UserDAO getUserDetailsDAO(SessionFactory
	  sessionFactory) {
	  
	  System.out.println("user dao wired "); return new
	  UserDAOImpl(sessionFactory); }
	  
	  @Autowired
	  
	  @Bean(name = "user") public User getUserDetails() {
	  System.out.println("user wired"); return new User(); }
	 
	 // product
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {

		System.out.println("product dao wired ");
		return new ProductDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "product")
	public Product getProduct() {
		System.out.println("product wired");
		return new Product();
	}

	// category
	@Autowired
	  
	  @Bean(name = "categoryDAO") public CategoryDAO
	  getCategoryDAO(SessionFactory sessionFactory) {
	  
	  System.out.println("category dao wired "); return new
	  CategoryDAOImpl(sessionFactory); }
	  
	  @Autowired
	 
	  @Bean(name = "category") public Category getCategory() {
	  System.out.println("category wired"); return new Category(); }
	 
	// supplier
	
	  @Autowired
	  
	  @Bean(name = "supplierDAO") public SupplierDAO
	  getSupplierDAO(SessionFactory sessionFactory) {
	  
	  System.out.println("supplier dao wired "); return new
	  SupplierDAOImpl(sessionFactory); }
	  
	  @Autowired
	  
	  @Bean(name = "supplier") public Supplier getSupplier() {
	  System.out.println("supplier wired"); return new Supplier(); }
	 

}
