package com.adopter.app.models.entity.region;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Distrito")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DistritoID")
	private Long id;
	
	@Column(name="Distrito")
	private String district;
	
	@ManyToOne
	@JoinColumn(name="ProvinciaID")
	private Province province;

	public District() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}