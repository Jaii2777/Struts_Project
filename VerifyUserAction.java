package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.form.VerifyUserForm;
import com.handler.VerifyUserHandler;


public class VerifyUserAction extends Action  {
	@Override 
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            	
            	VerifyUserForm verifyUserForm=(VerifyUserForm)  form;


            	if(verifyUserForm.getUname() == null )
            		return mapping.findForward("success");

            	System.out.println("okk...111");
            		System.out.println("u form"+verifyUserForm.getUname());
            	 if(verifyUserForm.getUname() != null) 
            	{
            		String status =VerifyUserHandler.verifyUser(verifyUserForm.getUname());
            		System.out.println("okk..."+status);
            		if(status.equals("verified")) {
            			HttpSession session=request.getSession(true);
            			session.setAttribute("userName",verifyUserForm.getUname());
            			System.out.println("Sesssion is "+session.getAttribute("userName"));
            			return mapping.findForward("verified");
            		}

            		else if(status.equals("failed")) {
						request.setAttribute("error","Invalid user");
            			return mapping.findForward("failed");
					}

            	}
            
            	return mapping.findForward("error");
            }
}