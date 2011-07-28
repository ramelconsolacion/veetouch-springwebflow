package org.veetouch.controller.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtProduct;
import org.veetouch.model.VtSubproduct;

@Service("vt_productService")
@Repository
public class JpaProductService implements ProductService
{
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
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
}
