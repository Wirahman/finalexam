package id.web.skyforce.bank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name="id", length = 11, nullable=false)
	private int id;
	
	@Column(name = "street", length = 50, nullable = false)
	private String street;
	
	@Column(name = "city", length = 50, nullable = false)
	private String city;
	
	@Column(name = "postal_code", length = 5, nullable = false)
	private String postalCode;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "customer_id", unique = true)
	private Customer customer;
	
	public Address(){}
	
	public Address(int id, int customerId, String street, String city,
			String postalCode) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}

