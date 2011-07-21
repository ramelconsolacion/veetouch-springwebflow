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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Lob()
	@Column(nullable=false)
	private String description;

	@Column(nullable=false, length=45)
	private String name;

	//uni-directional many-to-one association to VtSubproduct
    @ManyToOne
	@JoinColumn(name="vt_subproduct_id", nullable=false)
	private VtSubproduct vtSubproduct;

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