package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vt_product database table.
 * 
 */
@Entity
@Table(name="vt_product")
public class VtProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VtProductPK id;

	private Object description;

	private String name;

	//bi-directional many-to-one association to VtSubproduct
    @ManyToOne
	@JoinColumn(name="vt_subproduct_id", referencedColumnName="id")
	private VtSubproduct vtSubproduct;

    public VtProduct() {
    }

	public VtProductPK getId() {
		return this.id;
	}

	public void setId(VtProductPK id) {
		this.id = id;
	}
	
	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
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
	
}