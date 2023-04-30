package com.roberta.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORII")
public class CategorieCurs {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CATEGORIE")
	private Long idCategorie;
	
	@Column(name="DENUMIRE_CATEGORIE")
	private String denumireCategorie;
	
	@OneToMany(mappedBy="categorieCurs",fetch=FetchType.EAGER)
	Set<Curs>cursuri;
	
	public Long getIdCategorie() {
		return idCategorie;
	}
	public Set<Curs> getCursuri() {
		return cursuri;
	}
	public void setCursuri(Set<Curs> cursuri) {
		this.cursuri = cursuri;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDenumireCategorie() {
		return denumireCategorie;
	}
	public void setDenumireCategorie(String denumireCategorie) {
		this.denumireCategorie = denumireCategorie;
	}
	
	
}
