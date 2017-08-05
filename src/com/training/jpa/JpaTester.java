package com.training.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.training.entity.Address;
import com.training.entity.OrderBkp;

public class JpaTester {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExampleUnit");
		EntityManager em = emf.createEntityManager();

		OrderBkp order = new OrderBkp();
		
		order.getProducts().add("Samsung S8");
		order.setOrderDate(new Date());

		Address address = new Address();
		address.setAddress1("1290 Hidden Ridge");
		address.setCity("Irving");
		address.setState("TX");
		address.setZip("75038");
		address.setCountry("US");
		
		//order.setAddress(address);

		//Create
		em.getTransaction().begin();
		em.persist(order);
		em.getTransaction().commit();

		//find
		order = em.find(OrderBkp.class, 6);
		System.out.println(order);

		if(order == null)
			return;
		
		//update
		em.getTransaction().begin();
		order.setOrderDate(new Date());
		System.out.println("Order after updation :- " + order);		
		em.getTransaction().commit();

		//delete
		em.getTransaction().begin();
		em.remove(order);
		em.getTransaction().commit();

		order = em.find(OrderBkp.class, 6);
		System.out.println("Order after removal :- " + order);
	}
}
