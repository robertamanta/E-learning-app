package com.roberta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.mysql.jdbc.Blob;
@Entity
@Table(name="Imagini")
public class Imagine {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long idImagine;
	
	@Column(name="IMAGINE")
	@Lob
	private Blob imagine;

	public Long getIdImagine() {
		return idImagine;
	}

	public void setIdImagine(Long idImagine) {
		this.idImagine = idImagine;
	}

	public Blob getImagine() {
		return imagine;
	}

	public void setImagine(Blob imagine) {
		this.imagine = imagine;
	}
	
	
}
