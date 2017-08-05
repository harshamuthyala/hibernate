package com.training.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "ORDR")
public class OrderBkp {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PRODUCTS", joinColumns= {@JoinColumn(name="id")})
/*	@JoinTable(name="PRODUCTS")
	@SequenceGenerator(name="productIdGenerator", sequenceName="PRODUCT_ID_SEQ", initialValue=1000, allocationSize=1)
	@CollectionId(columns = { @Column(name="ID") }, generator = "productIdGenerator", type = @Type(type="long"))*/
	private Collection<String> products = new ArrayList<>();  

	//@Column(name = "ADDRS")
	@Embedded
	private Address shippingAddress;

/*	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="address1", column=@Column(name="baddress1")),
	@AttributeOverride(name="address2", column=@Column(name="baddress2")),
	@AttributeOverride(name="city", column=@Column(name="bcity")),
	@AttributeOverride(name="state", column=@Column(name="bstate")),
	@AttributeOverride(name="zip", column=@Column(name="bzip")),
	@AttributeOverride(name="country", column=@Column(name="bcountry"))
	})
	private Address billingAddress;*/
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ORD_DT")
	private Date orderDate;

	@Lob
	private String specialInstructions;

	@Transient
	boolean isNote5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

/*	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}*/

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public void setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isNote5() {

		return this.isNote5;
	}

	public Collection<String> getProducts() {
		return products;
	}

	public void setProducts(Collection<String> products) {
		this.products = products;
	}
}
