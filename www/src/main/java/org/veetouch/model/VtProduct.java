package org.veetouch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vt_product")
public class VtProduct implements Serializable
{
	private static final long serialVersionUID = 3200725800943324563L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idProduct")
	private int idProduct;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
