package org.veetouch.controller.product;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.primefaces.context.RequestContext;
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
	
	@Override
	@Transactional
	public boolean addMainProduct(VtMainproduct mainProduct) 
	{
		// 1. Validate Main Product
		if(validateMainProduct(mainProduct))
		{
			RequestContext context = RequestContext.getCurrentInstance();
			// 2. Commit into database
			this.em.persist(mainProduct);
			context.addCallbackParam("saved", true);
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean editMainProduct(VtMainproduct mainProduct)
	{
		// 1. Validate Main Product
		if(validateMainProduct(mainProduct))
		{
			RequestContext context = RequestContext.getCurrentInstance();
			// 2. Commit into database
			this.em.merge(mainProduct);
			context.addCallbackParam("saved", true);
			return true;
		}
		return false;
	}
	
	@Transactional
	public void removeMainProduct(VtMainproduct mainProduct) 
	{
		this.em.remove(em.find(VtMainproduct.class,mainProduct.getId()));
	}
	
	public boolean validateMainProduct(VtMainproduct mainProduct)
	{
		FacesMessage msg = null;
		try 
		{
			if(this.em.createQuery("SELECT vm FROM VtMainproduct vm where vm.name = '"+mainProduct.getName()+"'").getResultList().size() > 0)
			{
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Duplicate Product Name.", "Input Error");  
				throw new ValidatorException(msg);
			}
		}
		catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<VtMainproduct> listAllMainProduct() {
		//List<VtMainproduct> mainproductList = em.createQuery("SELECT vm FROM VtMainproduct vm LEFT JOIN FETCH vm.vtSubproducts GROUP BY vm.id").getResultList();
		//List<VtMainproduct> mainproductList = em.createQuery("SELECT vm FROM VtMainproduct vm LEFT JOIN FETCH vm.vtSubproducts").getResultList();
		List<VtMainproduct> mainproductList = em.createQuery("SELECT vm FROM VtMainproduct vm").getResultList();
		return mainproductList;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<VtProduct> listAllProduct() {
		List<VtProduct> productList = em.createQuery("from VtProduct").getResultList();
		return productList;
	}

	@Override
	public boolean addSubProduct(VtSubproduct subProduct) {
		// 1. Validate Main Product
		if(validateSubProduct(subProduct))
		{
			RequestContext context = RequestContext.getCurrentInstance();
			// 2. Commit into database
			this.em.persist(subProduct);
			context.addCallbackParam("saved", true);
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean editSubProduct(VtSubproduct subProduct)
	{
		// 1. Validate Sub Product
		if(validateSubProduct(subProduct))
		{
			RequestContext context = RequestContext.getCurrentInstance();
			// 2. Commit into database
			this.em.merge(subProduct);
			context.addCallbackParam("saved", true);
			return true;
		}
		return false;
	}
	
	@Transactional
	public void removeSubProduct(VtSubproduct subProduct) 
	{
		this.em.remove(em.find(VtSubproduct.class,subProduct.getId()));
		//this.em.remove(em.find(VtSubproduct.class,1));
	}
	
	public boolean validateSubProduct(VtSubproduct subProduct)
	{
		FacesMessage msg = null;
		try 
		{
			if(this.em.createQuery("SELECT vs FROM VtSubproduct vs where vs.name = '"+subProduct.getName()+"'").getResultList().size() > 0)
			{
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Duplicate Product Name.", "Input Error");  
				throw new ValidatorException(msg);
			}
		}
		catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
		return true;
	}

}
