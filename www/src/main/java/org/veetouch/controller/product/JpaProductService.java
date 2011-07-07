package org.veetouch.controller.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.veetouch.model.Product;

@Service("productService")
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
	public List<Product> listAllProduct() {
		List<Product> productList = em.createQuery("from Product").getResultList();
		return productList;
	}

}
