package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vt_service_ss database table.
 * 
 */
@Entity
@Table(name="vt_service_ss")
public class VtServiceSs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idvt_service_ss")
	private int idvtServiceSs;

	private String image;

	//bi-directional many-to-one association to VtService
    @ManyToOne
	@JoinColumn(name="vt_service_id")
	private VtService vtService;

    public VtServiceSs() {
    }

	public int getIdvtServiceSs() {
		return this.idvtServiceSs;
	}

	public void setIdvtServiceSs(int idvtServiceSs) {
		this.idvtServiceSs = idvtServiceSs;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public VtService getVtService() {
		return this.vtService;
	}

	public void setVtService(VtService vtService) {
		this.vtService = vtService;
	}
	
}