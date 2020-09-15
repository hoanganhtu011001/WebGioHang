package model;

import java.io.Serializable;

public class ProductCart implements Serializable{
	private Product prod;
	private int quanty;
	
	public ProductCart() {
		// TODO Auto-generated constructor stub
	}

	
	public ProductCart(Product prod) {
		super();
		this.prod = prod;
		this.quanty = 1;
	}


	public ProductCart(Product prod, int quanty) {
		super();
		this.prod = prod;
		this.quanty = quanty;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	
	
}
