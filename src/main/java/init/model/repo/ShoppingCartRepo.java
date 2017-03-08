package init.model.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import init.model.ShoppingCart;

@Repository
@Transactional
public class ShoppingCartRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public ShoppingCart save(ShoppingCart cart)		{ em.persist(cart); return cart; }
	
	public ShoppingCart update(ShoppingCart cart)	{ em.merge(cart); return cart; }
	
	public ShoppingCart findById(Long id){ 
		Query q =  em.createNamedQuery("fetchOneWithItems", ShoppingCart.class);
		q.setParameter(1, id);
		return (ShoppingCart) q.getSingleResult();
	}
	
	public List<ShoppingCart> allWithItems(){
		return em.createNamedQuery("fetchAllWithItems", ShoppingCart.class).getResultList();
	}

}
