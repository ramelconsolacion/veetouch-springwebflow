package org.veetouch.controller.admin.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veetouch.controller.product.ProductUtilService;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;
import org.veetouch.model.VtSubproduct;

@Service("vt_adminproductService")
@Repository
public class JpaAdminProductService implements AdminProductService
{
	private EntityManager em;
	
	private VtMainproduct selectedMainProduct;
	private VtSubproduct selectedSubProduct;
	private VtProduct selectedProduct;
	
	private String productName = "";
	private String productDes  = "";
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return productName;
	}

	@Override
	public void setProductName(String mainProductName) {
		this.productName = mainProductName;
	}
	
	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public VtMainproduct getSelectedMainProduct() {
		return selectedMainProduct;
	}

	public void setSelectedMainProduct(VtMainproduct selectedMainProduct) {
		this.selectedMainProduct = selectedMainProduct;
	}

	public VtSubproduct getSelectedSubProduct() {
		return this.selectedSubProduct;
	}

	public void setSelectedSubProduct(VtSubproduct selectedSubProduct) {
		this.selectedSubProduct = selectedSubProduct;
	}
	
	public VtProduct getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(VtProduct selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	@Override
	public void clearTempValue() {
		// TODO Auto-generated method stub
		this.productName  = "";
		this.productDes   = "";
		this.selectedMainProduct = null;
		this.selectedSubProduct  = null;
		this.selectedProduct = null;
	}
	
	@Transactional
	public boolean addMainProduct(ProductUtilService product_service)
	{
		VtMainproduct mainProduct = new VtMainproduct();
		mainProduct.setName(this.getProductName());
		return product_service.addMainProduct(mainProduct);
	}
	
	@Transactional
	public boolean addSubProduct(ProductUtilService product_service)
	{
		VtSubproduct subProduct = new VtSubproduct();
		subProduct.setName(this.getProductName());
		subProduct.setDescription(this.getProductDes());
		subProduct.setVtMainproduct(this.getSelectedMainProduct());
		return product_service.addSubProduct(subProduct);
	}
	
	@Transactional
	public boolean addProduct(ProductUtilService product_service)
	{
		VtProduct product = new VtProduct();
		product.setName(this.getProductName());
		product.setDescription(this.getProductDes());
		product.setVtSubproduct(this.getSelectedSubProduct());
		return product_service.addProduct(product);
	}
	
	@Transactional
	public List<VtProduct> getProductList()
	{
		if(this.selectedSubProduct == null)
		{
			return new ArrayList<VtProduct>();
		}
		return this.em.createQuery("SELECT p FROM VtProduct p where p.vtSubproduct.id="+this.selectedSubProduct.getId()).getResultList();
	}
}
