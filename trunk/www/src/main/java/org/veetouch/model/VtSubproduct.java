package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;


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

	@Column(length=45)
	private String name;

	@Column(name="vt_mainproduct_id", nullable=false)
	private int vtMainproductId;

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

	public int getVtMainproductId() {
		return this.vtMainproductId;
	}

	public void setVtMainproductId(int vtMainproductId) {
		this.vtMainproductId = vtMainproductId;
	}

}