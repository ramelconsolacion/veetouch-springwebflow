package org.veetouch.view.product;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.el.EvaluationException;
import javax.faces.el.MethodBinding;
import javax.faces.el.MethodNotFoundException;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtSubproduct;

public class MenuBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private MenuModel model;
	

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void init(ArrayList mainProductList)
	{
		ArrayList<VtMainproduct> temp_mainProductList = mainProductList;
		model = new DefaultMenuModel();
		for (VtMainproduct vtMainproduct : temp_mainProductList) 
		{
			Submenu submenu = new Submenu();
			submenu.setLabel(vtMainproduct.getName());
			for (VtSubproduct vtSubProduct : vtMainproduct.getVtSubproducts()) 
			{
				MenuItem item = new MenuItem();
				HtmlCommandLink commandLink = new HtmlCommandLink();
				commandLink.setValue(vtSubProduct.getName());
				//commandLink.setAction();
				commandLink.setType("submit");
				// commandLink.setAction(FacesContext.getCurrentInstance().getApplication().createMethodBinding("viewSubProduct",null));
				item.getChildren().add(commandLink);
				submenu.getChildren().add(item);
			}
			model.addSubmenu(submenu);
		}
	}
	
	public MenuModel getModel() 
	{
        return model;
    }
}
