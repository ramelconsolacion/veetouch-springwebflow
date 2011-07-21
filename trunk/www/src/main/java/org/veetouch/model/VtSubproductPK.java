package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vt_subproduct database table.
 * 
 */
@Embeddable
public class VtSubproductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="vt_mainproduct_id")
	private int vtMainproductId;

    public VtSubproductPK() {
    }
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVtMainproductId() {
		return this.vtMainproductId;
	}
	public void setVtMainproductId(int vtMainproductId) {
		this.vtMainproductId = vtMainproductId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VtSubproductPK)) {
			return false;
		}
		VtSubproductPK castOther = (VtSubproductPK)other;
		return 
			(this.id == castOther.id)
			&& (this.vtMainproductId == castOther.vtMainproductId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.vtMainproductId;
		
		return hash;
    }
}