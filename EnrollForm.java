package com.form;

import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public class EnrollForm extends ActionForm {
 
    private String q1 = null;
    private String q2 = null;
 
    public String getQ1() {
    	System.out.println("enroll form q1 is" +q1);
        return q1;
    }
 
    public void setQ1(String q1) {
        this.q1 = q1;
    }
 
    public String getQ2() {
		System.out.println("enroll form q2 is" +q2);
        return q2;
    }
 
    public void setQ2(String q2) {
        this.q2 = q2;
    }
 
}