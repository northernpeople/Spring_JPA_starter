package init.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import init.Config;
import init.model.repo.ShoppingCartRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class ShoppingCartRepoTest {
	
	@Autowired
	ShoppingCartRepo repo;
	
	private ShoppingCart cart;

	@Before
	public void setUp(){
		cart = new ShoppingCart("amazon shopping cart");
	}
	
	@Test
	public void shouldSave(){
		cart = repo.save(cart);
		assertNotNull(repo.findById(cart.getId()));
	}

}
