package org.veetouch.controller.admin.product;

import java.util.List;

import org.veetouch.controller.product.ProductService;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;
import org.veetouch.model.VtSubproduct;


public interface AdminProductService 
{
	/**
	 * Temp value
	 */
	public String getProductName();	
	public void setProductName(String mainProductName);
	public String getProductDes();
	public void setProductDes(String productDes);
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
	 * Main product
	 */
	public boolean addMainProduct(ProductService product_service);
	public VtMainproduct getSelectedMainProduct();
	public void setSelectedMainProduct(VtMainproduct selectedMainProduct);
	
	/**
	 * Sub product
	 */
	public boolean addSubProduct(ProductService product_service);
	public VtSubproduct getSelectedSubProduct();
	public void setSelectedSubProduct(VtSubproduct selectedSubProduct);

}
