package com.training.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.training.entity.Address;
import com.training.entity.Employee;
import com.training.entity.Order;
import com.training.entity.OrderBkp;
import com.training.entity.Product;
import com.training.entity.Role;
import com.training.entity.User;

public class HibernateTester {

	public static void main(String[] args) {
		
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory();) {
		
			createOrder(sf);		
		}
	}

	private static void createOrder(SessionFactory sf ) {
		
		Order order = new Order();
		
		order.setOrderDate(new Date());
		
		Product product = new Product();
		product.setName("Samsung Note7");
		product.setOrder(order);
		
		//order.getProducts().add(product);
		
		Product product1 = new Product();
		product1.setName("Samsung Note 5");
		
		//order.getProducts().add(product);
		
		product1.setOrder(order);
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(product);
		session.save(product1);
		
		session.getTransaction().commit();
		
		session = sf.openSession();
		order = session.get(Order.class, 1);
		
		System.out.println(order);
		
		session.close();
	}
/*
	private static void createOrderBkp() {
		OrderBkp order = new OrderBkp();
		//order.setId(400);
		
		order.getProducts().add("Samsung S8");
		order.getProducts().add("Samsung S8+");
		
		order.setOrderDate(new Date());

		Address address = new Address();
		address.setAddress1("1290 Hidden Ridge");
		address.setCity("Irving");
		address.setState("TX");
		address.setZip("75038");
		address.setCountry("US");
		
		order.setShippingAddress(address);
		
		Address baddress = new Address();
		baddress.setAddress1("1290 Hidden Ridge2");
		baddress.setCity("Irving");
		baddress.setState("TX");
		baddress.setZip("75038");
		baddress.setCountry("US");
		
		//order.setBillingAddress(baddress);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(order);
		session.getTransaction().commit();
		
		session = sf.openSession();
		order = session.get(OrderBkp.class, 1);
		
		System.out.println(order);
		
		session.close();
		
		System.out.println(order.getProducts().size());
		
		sf.close();
	}

	private static void createUser() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		User user = new User();
		
		user.setFirstName("FName");
		user.setLastName("LName");
	
		//user.setEmail("abc3@test.com");
		
		user.getEmail().add("abc3@test.com");
		user.getEmail().add("abc2@test.com");	
		user.getEmail().add("abc4@test.com");
		
		session.save(user);
		//session.save(order);
		session.getTransaction().commit();
		
		sf.close();
	}

	private static void testOneToOne(){
		
		Employee emp = new Employee();
		emp.setEmail("test@xyz.com");
		emp.setName("Test Me");
		
		Role role = new Role();
		role.setCode("PM");
		role.setDescription("Project Manager");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(emp);
		session.save(role);
		session.getTransaction().commit();
		
		sf.close();
	}*/
}
