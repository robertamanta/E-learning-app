package com.roberta.model;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Roluri")
public class TipUtilizator {

	@Id
	@Column(name="ID_ROL")
	private Long idTipUtilizator;
	
	@Column(name="ROL", nullable=false,unique=true)
	private String tip;
	
//	@ManyToMany(mappedBy="usertypes")
//	private Set<User> users=new HashSet<User>();

	@OneToMany(mappedBy="tipUtilizator",fetch=FetchType.EAGER)
	private List<Utilizator> utilizatori=new ArrayList<Utilizator>();

	public Long getIdTipUtilizator() {
		return idTipUtilizator;
	}

	public void setIdTipUtilizator(Long idTipUtilizator) {
		this.idTipUtilizator = idTipUtilizator;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Utilizator> getUtilizatori() {
		return utilizatori;
	}

	public void setUtilizatori(List<Utilizator> utilizatori) {
		this.utilizatori = utilizatori;
	}
	
	
}