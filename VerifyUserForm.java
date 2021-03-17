package com.form;

import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public class VerifyUserForm extends ActionForm {
 
    private String uname = null;
  
    public String getUname() {
    	System.out.println("uname is" +uname);
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
}