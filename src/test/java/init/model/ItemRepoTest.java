package init.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import init.Config;
import init.model.repo.ItemRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class ItemRepoTest {

	@Autowired
	ItemRepo repo;
	
	private Item item;

	@Before
	public void setUp(){
		item = new Item("shampoo");
	}
	
	@Test
	public void shouldSave(){
		item = repo.save(item);
		System.out.println(repo.findById(item.getId()));
		assertNotNull(repo.findById(item.getId()));
	}
	
	@Test
	public void shouldManageTags(){
		item = repo.save(item);
		assertNotNull(repo.findById(item.getId()));
		
		// add
		item.getTags().add("tag1");
		item = repo.update(item);
		assertTrue(repo.findById(item.getId()).getTags().contains("tag1"));
		
		// remove
		item = repo.findById(item.getId()); // refetch item
		item.getTags().remove("tag1");
		item.setName("two");
		item = repo.update(item);
		assertFalse(repo.findById(item.getId()).getTags().contains("tag1"));
	}
	
}
