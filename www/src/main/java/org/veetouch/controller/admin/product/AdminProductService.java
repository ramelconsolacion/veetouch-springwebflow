package org.veetouch.controller.admin.product;

import java.util.List;

import org.veetouch.controller.product.ProductUtilService;
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
	 * Main product
	 */
	public boolean addMainProduct(ProductUtilService product_service);
	public VtMainproduct getSelectedMainProduct();
	public void setSelectedMainProduct(VtMainproduct selectedMainProduct);
	
	/**
	 * Sub product
	 */
	public boolean addSubProduct(ProductUtilService product_service);
	public VtSubproduct getSelectedSubProduct();
	public void setSelectedSubProduct(VtSubproduct selectedSubProduct);
	
	/**
	 * Products list
	 */
	public boolean addProduct(ProductUtilService product_service);
	public VtProduct getSelectedProduct();
	public void setSelectedProduct(VtProduct selectedProduct);
	public List<VtProduct> getProductList();

}
