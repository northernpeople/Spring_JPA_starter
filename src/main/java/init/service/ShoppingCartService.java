package init.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import init.model.Item;
import init.model.ShoppingCart;
import init.model.repo.ItemRepo;
import init.model.repo.ShoppingCartRepo;

@Component
public class ShoppingCartService {
	
	private ItemRepo itemRepo;
	private ShoppingCartRepo cartRepo;
	
	@Autowired
	public ShoppingCartService(ItemRepo itemRepo, ShoppingCartRepo cartRepo) {
		this.itemRepo = itemRepo;
		this.cartRepo = cartRepo;
	}
	
	public void addItemToCart(Item item, ShoppingCart cart){
		Assert.notNull(item, "item cannot be null");
		Assert.notNull(cart, "cart cannot be null");
		Assert.notNull(item.getId(), "item id cannot be null");
		Assert.notNull(cart.getId(), "cart id cannot be null");
		item.setCart(cart);
		cart.getItems().add(item);
		itemRepo.update(item);
	}
	
	

}
