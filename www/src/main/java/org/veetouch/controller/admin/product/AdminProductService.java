package org.veetouch.controller.admin.product;

import java.util.List;

import org.veetouch.model.VtMainproduct;


public interface AdminProductService 
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
	public List<VtMainproduct> listAllProduct();
}
