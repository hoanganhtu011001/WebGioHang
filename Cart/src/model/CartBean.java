package model;

import java.util.HashMap;

public class CartBean extends HashMap{
	public void addtocart(ProductCart prod) {
		String key = prod.getProd().getCode();
		if(this.containsKey(key)) {
			int oldquanty = ((ProductCart)this.get(key)).getQuanty();
			((ProductCart)this.get(key)).setQuanty(oldquanty + 1);
		}
		else {
			this.put(prod.getProd().getCode(), prod);
		}
	}
	public void removecart(String code) {
			if(this.containsKey(code)) {
				this.remove(code);
			}
	}
}
