package org.veetouch.controller.product;

import java.util.List;

import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;
import org.veetouch.model.VtSubproduct;

public interface ProductService 
{
	public boolean addMainProduct(VtMainproduct mainProduct);
	public void removeMainProduct(VtMainproduct mainProduct);
	public boolean editMainProduct(VtMainproduct mainProduct);
	public List<VtMainproduct> listAllMainProduct();
	public List<VtProduct> listAllProduct();
	
	
	public boolean addSubProduct(VtSubproduct subProduct);
	public void removeSubProduct(VtSubproduct subProduct);
	public boolean editSubProduct(VtSubproduct subProduct);
}
