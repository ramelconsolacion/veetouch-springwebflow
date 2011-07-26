package org.veetouch.controller.product;

import java.util.List;

import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;
import org.veetouch.model.VtSubproduct;

public interface ProductService 
{
	/**
	 * Get list of all main product
	 * @return List of main product
	 */
	public List<VtMainproduct> listAllMainProduct();
	
	/**
	 * Get list of all product
	 * @return List of product
	 */
	public List<VtProduct> listAllProduct();
	
}
