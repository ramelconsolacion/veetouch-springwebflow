package org.veetouch.controller.admin.product;

import java.util.List;

import org.veetouch.controller.product.ProductService;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;


public interface AdminProductService 
{
	/**
	 * Clear Temp value after submit to the system
	 */
	public void clearTempValue();
	
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
	
	
	/**
	 * Add main product
	 */
	public boolean addMainProduct(ProductService product_service);
	
	public String getMainProductName();	
	public void setMainProductName(String mainProductName);

}
