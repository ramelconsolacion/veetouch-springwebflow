package org.veetouch.components.menu;

import java.io.Serializable;

import javax.annotation.PostConstruct;

public class MenuNavigator implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String page;
	
	@PostConstruct
	public void init()
	{
		this.page = "HOME";
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
}
