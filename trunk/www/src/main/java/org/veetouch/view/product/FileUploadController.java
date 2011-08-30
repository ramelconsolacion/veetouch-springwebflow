package org.veetouch.view.product;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import org.apache.myfaces.custom.fileupload.UploadedFile;

public class FileUploadController implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private UploadedFile uploadedFile;
	
	public void setUploadedFile(UploadedFile up) 
	{
		this.uploadedFile = up;
	}
	
	public UploadedFile getUploadedFile() 
	{
		return uploadedFile;
	}
	
	public void verifyUploadFile()
	{
		FacesMessage msg = null;
		if(this.uploadedFile == null)
		{
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"File Upload Controller File is null.", "Error");  
			throw new ValidatorException(msg);
		}
		msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"File Upload Controller File is Ok."+this.uploadedFile.getName(), "Error");  
		throw new ValidatorException(msg);
	}
}
