package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vt_product database table.
 * 
 */
@Entity
@Table(name="vt_product")
public class VtProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Lob()
	@Column(nullable=false)
	private String description;

	@Column(length=45)
	private String logo;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to VtSubproduct
    @ManyToOne
	@JoinColumn(name="vt_subproduct_id", nullable=false)
	private VtSubproduct vtSubproduct;

	//bi-directional many-to-one association to VtProductSs
	@OneToMany(mappedBy="vtProduct")
	private List<VtProductSs> vtProductSses;

    public VtProduct() {
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

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VtSubproduct getVtSubproduct() {
		return this.vtSubproduct;
	}

	public void setVtSubproduct(VtSubproduct vtSubproduct) {
		this.vtSubproduct = vtSubproduct;
	}
	
	public List<VtProductSs> getVtProductSses() {
		return this.vtProductSses;
	}

	public void setVtProductSses(List<VtProductSs> vtProductSses) {
		this.vtProductSses = vtProductSses;
	}
	
}