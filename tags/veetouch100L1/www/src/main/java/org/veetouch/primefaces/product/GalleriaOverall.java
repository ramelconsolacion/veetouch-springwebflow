package org.veetouch.primefaces.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class GalleriaOverall implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private List<String> images;
	
	@PostConstruct
	public void init() {
		this.images = new ArrayList<String>();
		for(int i=1;i<=10;i++) {  
            images.add("galleria" + i + ".jpg");  
        }
	}
	
	public List<String> getImages() {  
        return images;  
    }
}
