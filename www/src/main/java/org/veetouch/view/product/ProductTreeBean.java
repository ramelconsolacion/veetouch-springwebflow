package org.veetouch.view.product;

import java.io.Serializable;
import java.util.ArrayList;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.veetouch.model.VtMainproduct;
import org.veetouch.model.VtSubproduct;

public class ProductTreeBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private TreeNode root;
	
	public void init(ArrayList mainProductList)
	{
		ArrayList<VtMainproduct> temp_mainProductList = mainProductList;
		
		this.root = new DefaultTreeNode("Root", null);
		for (VtMainproduct vtMainproduct : temp_mainProductList) 
		{
			TreeNode mpNode = new DefaultTreeNode(vtMainproduct,this.root);
			
			// Add Sub product list
			for (VtSubproduct vtSubproduct : vtMainproduct.getVtSubproducts()) {
				new DefaultTreeNode(vtSubproduct,mpNode);
			}
		}
	}
	
	public TreeNode getRoot() 
	{
        return root;
    }
}
