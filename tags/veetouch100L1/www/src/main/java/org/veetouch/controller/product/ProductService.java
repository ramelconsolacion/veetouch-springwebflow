package org.veetouch.controller.product;

import org.veetouch.model.VtSubproduct;

public interface ProductService 
{
	/**
	 * Temp value
	 */
	public VtSubproduct getSelectedSubProduct();
	public void setSelectedSubProduct(VtSubproduct selectedSubProduct);
	
	
}
