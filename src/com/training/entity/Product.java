package com.training.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NME")
	private String name;
	
/*	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@JoinColumn(name="order_id")*/
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordr_id")
	private Order order;

	public Product() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
