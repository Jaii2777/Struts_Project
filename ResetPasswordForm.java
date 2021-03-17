package com.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public class ResetPasswordForm extends ActionForm {
 
    private String newPassword = null;
    private String confirmPassword=null;
  
   	public String getNewPassword()
   	{
		return newPassword;
   	}
   	public void setNewPassword(String newPassword) {

   		this.newPassword=newPassword;
   		
   	}
   	public String getConfirmPassword()
   	{
   		
		return confirmPassword;
   	}
   	public void setConfirmPassword(String confirmPassword) {
   		this.confirmPassword=confirmPassword;
   				
   	}

}