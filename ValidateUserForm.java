package com.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public class ValidateUserForm extends ActionForm {
 
    private String ans1 = null;
    private String ans2=null;
  
   	public String getOne()
   	{
   		System.out.println("yes"+ans1);
		return ans1;
   	}
   	public void setAns1(String ans1) {

   		this.ans1=ans1;
   		System.out.println("set 1"+ans1);
   		getOne();
   	}
   	public String getTwo()
   	{
   		System.out.println("second" +ans2); 	
		return ans2;
   	}
   	public void setAns2(String ans2) {
   		this.ans2=ans2;
   		System.out.println("set 2"+ans2);
   		getTwo();		
   	}

}