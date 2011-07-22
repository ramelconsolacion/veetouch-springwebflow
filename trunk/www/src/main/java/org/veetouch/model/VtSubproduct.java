package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vt_subproduct database table.
 * 
 */
@Entity
@Table(name="vt_subproduct")
public class VtSubproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;

	//bi-directional many-to-one association to VtProduct
	@OneToMany(mappedBy="vtSubproduct")
	private List<VtProduct> vtProducts;

	//bi-directional many-to-one association to VtMainproduct
    @ManyToOne
	@JoinColumn(name="vt_mainproduct_id")
	private VtMainproduct vtMainproduct;

    public VtSubproduct() {
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

	public List<VtProduct> getVtProducts() {
		return this.vtProducts;
	}

	public void setVtProducts(List<VtProduct> vtProducts) {
		this.vtProducts = vtProducts;
	}
	
	public VtMainproduct getVtMainproduct() {
		return this.vtMainproduct;
	}

	public void setVtMainproduct(VtMainproduct vtMainproduct) {
		this.vtMainproduct = vtMainproduct;
	}
	
}