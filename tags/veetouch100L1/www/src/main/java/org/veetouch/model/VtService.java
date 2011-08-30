package org.veetouch.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vt_service database table.
 * 
 */
@Entity
@Table(name="vt_service")
public class VtService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Lob()
	@Column(nullable=false)
	private String description;

	@Column(length=55)
	private String logo;

	//bi-directional many-to-one association to VtServiceSs
	@OneToMany(mappedBy="vtService")
	private List<VtServiceSs> vtServiceSses;

    public VtService() {
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

	public List<VtServiceSs> getVtServiceSses() {
		return this.vtServiceSses;
	}

	public void setVtServiceSses(List<VtServiceSs> vtServiceSses) {
		this.vtServiceSses = vtServiceSses;
	}
	
}