package org.veetouch.controller.admin.product;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veetouch.controller.product.ProductService;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;

@Service("vt_adminproductService")
@Repository
public class JpaAdminProductService implements AdminProductService
{
	private EntityManager em;
	
	private String mainProductName;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void clearTempValue() {
		// TODO Auto-generated method stub
		this.mainProductName  = "";
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<VtMainproduct> listAllMainProduct() {
		List<VtMainproduct> mainproductList = em.createQuery("SELECT vm FROM VtMainproduct vm LEFT JOIN FETCH vm.vtSubproducts GROUP BY vm.id").getResultList();
		return mainproductList;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<VtProduct> listAllProduct() {
		List<VtProduct> productList = em.createQuery("from VtProduct").getResultList();
		return productList;
	}
	
	@Transactional
	public boolean addMainProduct(ProductService product_service)
	{
		VtMainproduct mainProduct = new VtMainproduct();
		mainProduct.setName(this.getMainProductName());
		return product_service.addMainProduct(mainProduct);
	}

	@Override
	public String getMainProductName() {
		// TODO Auto-generated method stub
		return mainProductName;
	}

	@Override
	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}


}
