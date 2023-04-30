package com.roberta.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PROFESORI")
@PrimaryKeyJoinColumn(name="NUME_UTILIZATOR")
public class Profesor extends Utilizator {

	@OneToMany(mappedBy="profesor",fetch=FetchType.EAGER)
	Set<Curs> cursuriProfesor=new HashSet<Curs>();
	
	@OneToMany(mappedBy="profesorGrup")
	List<Grup> grupuri = new ArrayList<Grup>();
	
	

	public Set<Curs> getCursuriProfesor() {
		return cursuriProfesor;
	}

	public void setCursuriProfesor(Set<Curs> cursuriProfesor) {
		this.cursuriProfesor = cursuriProfesor;
	}
	

	
}
