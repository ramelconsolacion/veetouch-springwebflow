package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_user database table.
 * 
 */
@Entity
@Table(name="customer_user")
public class CustomerUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="customer_company_id")
	private int customerCompanyId;

	private String email;

	private Object gender;

	private String password;

	private String phone;

	private String username;

    public CustomerUser() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerCompanyId() {
		return this.customerCompanyId;
	}

	public void setCustomerCompanyId(int customerCompanyId) {
		this.customerCompanyId = customerCompanyId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object getGender() {
		return this.gender;
	}

	public void setGender(Object gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}