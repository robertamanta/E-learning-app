package com.roberta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.roberta.model.Utilizator;
import com.roberta.model.TipUtilizator;

@Repository("userRepository")
public class UtilizatorDaoImpl extends MainDao<Utilizator>implements UtilizatorDao {

	public UtilizatorDaoImpl() {
		super(Utilizator.class);
		// TODO Auto-generated constructor stub
	}

	public Utilizator findUser(String username) {
//		
//		Query query=this.entityManager
//				.createQuery("from Utilizatori where nume_utilizator=?")
//				.setParameter(0, username);
//		return (User) query.getSingleResult();
//		
	    CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
	    CriteriaQuery<Utilizator> cq=builder.createQuery(Utilizator.class);
	    Root<Utilizator> user=cq.from(Utilizator.class);
	    cq.select(user);
	    cq.where(builder.equal(user.get("numeUtilizator"),username));
	    List<Utilizator> found=this.entityManager.createQuery(cq).getResultList();
	    if(found.isEmpty())
	    {
	    	return null;
	    }else{
	    
	  //  System.out.println(found.getFirstName()+" "+foundUser.getLastName()+" "+foundUser.getEmail()+" "+foundUser.getPassword());
	    return found.get(0);
	    }
	}
    @Transactional
	public Utilizator insertUser(Utilizator user) {
		this.entityManager.merge(user);
		return user;
	}

	
	



}
