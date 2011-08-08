package org.veetouch.controller.product;

import java.util.List;

import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;
import org.veetouch.model.VtSubproduct;

public interface ProductUtilService 
{
	public List<VtMainproduct> listMenuMainProduct();
	
	public boolean addMainProduct(VtMainproduct mainProduct);
	public void removeMainProduct(VtMainproduct mainProduct);
	public boolean editMainProduct(VtMainproduct mainProduct);
		
	public boolean addSubProduct(VtSubproduct subProduct);
	public boolean editSubProduct(VtSubproduct subProduct);
	public void removeSubProduct(VtSubproduct subProduct);
	
	public boolean addProduct(VtProduct subProduct);
	public boolean editProduct(VtProduct subProduct);
	public void removeProduct(VtProduct product);
	public List<VtProduct> getProductList(int product_id);
	
}
