package com.form;

import javax.servlet.http.HttpServletRequest;
 
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
 
public class ChangePasswordForm extends ActionForm {

    private String q1 = null;
    private String q2 = null;
	private String q3 = null;
 
    public String getQ1() {
    	System.out.println("q1 is" +q1);
        return q1;
    }
 
    public void setQ1(String q1) {
        this.q1 = q1;
    }
 
    public String getQ2() {
		System.out.println("q2 is" +q2);
        return q2;
    }
 
    public void setQ2(String q2) {
        this.q2 = q2;
    }
	public String getQ3() {
    	System.out.println("q3 is" +q3);
        return q3;
    }
 
    public void setQ3(String q3) {
        this.q3 = q3;
    }
 
}


 
  /*  private String oldpass = null;
    private String newpass = null;
    private String confirmpass=null;
 
    public String getOldpass() {
        System.out.println("old pass is" +oldpass);
        getNewpass();
        getConfirmPass();
        return oldpass;
    }
 
    public void setOldass(String oldpass) {
        this.oldpass = oldpass;
        System.out.println("set old"+oldpass);
    }
 
    public String getNewpass() {
        System.out.println("new  pass is" +newpass);
        return newpass;
    }
 
    public void setNewpass(String newpass) {
        this.newpass = newpass;
        System.out.println("set new"+newpass);
    }
    public String getConfirmPass() {
        System.out.println("conf pass is" +confirmpass);
        return confirmpass;
    }
 
    public void setConfirmPass(String confirmpass) {
        this.confirmpass = confirmpass;
        System.out.println("set conf"+confirmpass);
    }
 */
 
