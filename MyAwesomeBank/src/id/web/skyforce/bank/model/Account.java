package id.web.skyforce.bank.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="saving_account")
public class Account {

		@Id
		@GeneratedValue
		@Column(name="id", length = 11, nullable=false)
		private int id;
		
		@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
		@JoinColumn(name = "customer_id", unique = true)
		private Customer customer;
		
		@Column(name="account_no", length = 10, nullable = false)
		private String account_no;
		
		@Column(name="balance", length = (int) 15.2, nullable = false)
		private BigDecimal balance;
		
		@Column(name="status", length = 1, nullable = false)
		private String status;
		
		public Account(){
			
		}
		
		public Account(int id, int customerId, String account_no, BigDecimal balance, String status){
			this.id = id;
			this.account_no = account_no;
			this.balance = balance;
			this.status = status;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public String getAccount_no() {
			return account_no;
		}

		public void setAccount_no(String account_no) {
			this.account_no = account_no;
		}

		public BigDecimal getBalance() {
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
}
