package init.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import init.Config;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class ItemRepoTest {

	@Autowired
	ItemRepo repo;
	
	Item item;

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
	
}
