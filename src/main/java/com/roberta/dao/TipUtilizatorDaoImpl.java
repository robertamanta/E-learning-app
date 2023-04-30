package com.roberta.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.roberta.model.Utilizator;
import com.roberta.model.TipUtilizator;
@Repository("userTypeRepository")
public class TipUtilizatorDaoImpl extends MainDao<TipUtilizator> implements TipUtilizatorDao{

	public TipUtilizatorDaoImpl() {
		super(TipUtilizator.class);
		
	}

	public TipUtilizator findType(String type) {
		    CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
		    CriteriaQuery<TipUtilizator> cq=builder.createQuery(TipUtilizator.class);
		    Root<TipUtilizator> userType=cq.from(TipUtilizator.class);
		    cq.select(userType);
		    cq.where(builder.equal(userType.get("tip"),type));
		    List<TipUtilizator> found=this.entityManager.createQuery(cq).getResultList();
		    if(found.isEmpty())
		    {
		    	return null;
		    }else{
		    
		  //  System.out.println(found.getFirstName()+" "+foundUser.getLastName()+" "+foundUser.getEmail()+" "+foundUser.getPassword());
		    return found.get(0);
		    }
	
	}

}
	


