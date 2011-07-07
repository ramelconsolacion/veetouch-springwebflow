package org.veetouch.controller.product;

import java.util.List;

import org.veetouch.model.Product;

public interface ProductService 
{
	
	/**
	 * Get list of all product
	 * @return List of product
	 */
	public List<Product> listAllProduct();
	
}
