package init.model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ItemRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public Item save(Item item)		{ em.persist(item); return item; }
	
	public void update(Item item)	{ em.merge(item); }
	
	public Item findById(Long id)	{ return em.find(Item.class, id); }
	
}
