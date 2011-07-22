package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vt_mainproduct database table.
 * 
 */
@Entity
@Table(name="vt_mainproduct")
public class VtMainproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to VtSubproduct
	@OneToMany(mappedBy="vtMainproduct")
	private List<VtSubproduct> vtSubproducts;

    public VtMainproduct() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VtSubproduct> getVtSubproducts() {
		return this.vtSubproducts;
	}

	public void setVtSubproducts(List<VtSubproduct> vtSubproducts) {
		this.vtSubproducts = vtSubproducts;
	}
	
}