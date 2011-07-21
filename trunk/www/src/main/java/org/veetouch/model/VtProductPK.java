package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the vt_product database table.
 * 
 */
@Embeddable
public class VtProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="vt_subproduct_id")
	private int vtSubproductId;

    public VtProductPK() {
    }
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVtSubproductId() {
		return this.vtSubproductId;
	}
	public void setVtSubproductId(int vtSubproductId) {
		this.vtSubproductId = vtSubproductId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VtProductPK)) {
			return false;
		}
		VtProductPK castOther = (VtProductPK)other;
		return 
			(this.id == castOther.id)
			&& (this.vtSubproductId == castOther.vtSubproductId);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.vtSubproductId;
		
		return hash;
    }
}