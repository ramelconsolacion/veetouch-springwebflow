package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vt_product_ss database table.
 * 
 */
@Entity
@Table(name="vt_product_ss")
public class VtProductSs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idvt_product_ss")
	private int idvtProductSs;

	private String image;

	//bi-directional many-to-one association to VtProduct
    @ManyToOne
	@JoinColumn(name="vt_product_id")
	private VtProduct vtProduct;

    public VtProductSs() {
    }

	public int getIdvtProductSs() {
		return this.idvtProductSs;
	}

	public void setIdvtProductSs(int idvtProductSs) {
		this.idvtProductSs = idvtProductSs;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public VtProduct getVtProduct() {
		return this.vtProduct;
	}

	public void setVtProduct(VtProduct vtProduct) {
		this.vtProduct = vtProduct;
	}
	
}