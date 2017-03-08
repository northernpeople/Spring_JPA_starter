package init.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import init.Config;
import init.model.Item;
import init.model.ShoppingCart;
import init.model.repo.ItemRepo;
import init.model.repo.ShoppingCartRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class)
public class ShoppingCartServiceTest {

	@Autowired
	ShoppingCartService service;
	
	@Autowired
	ItemRepo itemRepo;
	
	@Autowired
	ShoppingCartRepo cartRepo;
	
	
	@Test
	public void shouldAddItemToCart(){
		Item item = itemRepo.save(new Item("item1"));
		ShoppingCart cart = cartRepo.save(new ShoppingCart("cart"));
		service.addItemToCart(item, cart);
		
		System.out.println(cartRepo.allWithItems());
		
		cart = cartRepo.findById(cart.getId());
		assertTrue(cart.getItems().contains(item));
	}
}
