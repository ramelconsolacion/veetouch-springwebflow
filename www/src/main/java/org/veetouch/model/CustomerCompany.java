package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_company database table.
 * 
 */
@Entity
@Table(name="customer_company")
public class CustomerCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

    public CustomerCompany() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}