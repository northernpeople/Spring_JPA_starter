package init.model.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import init.model.Item;

@Repository
@Transactional
public class ItemRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	public Item save(Item item)		{ em.persist(item); return item; }
	
	public Item update(Item item)	{ em.merge(item); return item; }
	
	public Item findById(Long id)	{ return em.find(Item.class, id); }
	
}
