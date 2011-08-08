package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	@Column(unique=true, nullable=false)
	private int id;

    @Lob()
	@Column(nullable=false)
	private String description;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to VtProduct
	//@OneToMany(mappedBy="vtSubproduct")
	//@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH}, fetch = FetchType.EAGER,mappedBy="vtSubproduct")
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH}, fetch = FetchType.LAZY,mappedBy="vtSubproduct")
	private List<VtProduct> vtProducts;

	//bi-directional many-to-one association to VtMainproduct
    @ManyToOne
	@JoinColumn(name="vt_mainproduct_id", nullable=false)
	private VtMainproduct vtMainproduct;

    public VtSubproduct() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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