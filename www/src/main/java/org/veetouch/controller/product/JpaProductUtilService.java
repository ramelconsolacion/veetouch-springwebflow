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

@Service("vt_productUtilService")
@Repository
public class JpaProductUtilService implements ProductUtilService
{
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<VtMainproduct> listMenuMainProduct() {
		List<VtMainproduct> mainproductList = em.createQuery("SELECT vm FROM VtMainproduct vm").getResultList();
		return mainproductList;
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
			List<VtMainproduct> mainProducts = this.em.createQuery("SELECT vm FROM VtMainproduct vm where vm.name = '"+mainProduct.getName()+"'").getResultList();
			if(mainProducts.size() == 1)
			{
				if(mainProducts.get(0).getId() != mainProduct.getId())
				{
					msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Duplicate Product Name.", "Input Error");  
					throw new ValidatorException(msg);
				}
			}
		}
		catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
		return true;
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
	}
	
	public boolean validateSubProduct(VtSubproduct subProduct)
	{
		FacesMessage msg = null;
		try 
		{
			List<VtSubproduct> subProducts = this.em.createQuery("SELECT vm FROM VtSubproduct vm where vm.name = '"+subProduct.getName()+"'").getResultList();
			if(subProducts.size() == 1)
			{
				if(subProducts.get(0).getId() != subProduct.getId())
				{
					msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Duplicate Product Name.", "Input Error");  
					throw new ValidatorException(msg);
				}
			}
		}
		catch(Exception e)
		{
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean addProduct(VtProduct product)
	{
		// 1. Validate Main Product
		if(validateProduct(product))
		{
			RequestContext context = RequestContext.getCurrentInstance();
			// 2. Commit into database
			this.em.persist(product);
			context.addCallbackParam("saved", true);
			return true;
		}
		return false;
	}
	
	@Transactional
	public boolean editProduct(VtProduct product)
	{
		// 1. Validate Sub Product
		if(validateProduct(product))
		{
			RequestContext context = RequestContext.getCurrentInstance();
			// 2. Commit into database
			this.em.merge(product);
			context.addCallbackParam("saved", true);
			return true;
		}
		return true;
	}
	
	@Transactional
	public void removeProduct(VtProduct product) 
	{
		this.em.remove(em.find(VtProduct.class,product.getId()));
	}
	
	@Transactional
	public List<VtProduct> getProductList(int product_id)
	{
		return this.em.createQuery("SELECT p FROM VtProduct p where p.vtSubproduct.id="+product_id).getResultList();
	}
	
	public boolean validateProduct(VtProduct product)
	{
		FacesMessage msg = null;
		try 
		{
			List<VtProduct> products = this.em.createQuery("SELECT vm FROM VtProduct vm where vm.name = '"+product.getName()+"'").getResultList();
			if(products.size() == 1)
			{
				if(products.get(0).getId() != product.getId())
				{
					msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Duplicate Product Name.", "Input Error");  
					throw new ValidatorException(msg);
				}
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
