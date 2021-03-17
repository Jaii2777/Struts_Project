package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.form.ValidateUserForm;
import com.form.VerifyUserForm;
import com.handler.ValidateUserHandler;
public class ValidateUserAction extends Action  {
	@Override 
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            	ValidateUserForm validateUserForm=(ValidateUserForm) form;
            	

            	HttpSession session=request.getSession();
            	String userName=(String) session.getAttribute("userName");
 				System.out.println("XaA"+" "+validateUserForm.getOne()+" "+validateUserForm.getTwo()+" "+userName);
            	
 				String status=ValidateUserHandler.validateUser(validateUserForm.getOne(),validateUserForm.getTwo(),userName);
 				System.out.println("status is "+status);
 				if(status.equals("verified")) {
            	return 	mapping.findForward("success");
            	}
            	else if(status.equals("WrongAns1"))
            	{
            		String exe="Wrong Answer for Secret Quest 1";
            		request.setAttribute("WrongAns",exe);
            		request.getRequestDispatcher("/verifyUser.jsp").forward(request, response);
            	}

            	else if(status.equals("WrongAns2"))
            	{
            		String exe="Wrong Answer for Secret Quest 2";
            		request.setAttribute("WrongAns",exe);
            		request.getRequestDispatcher("/verifyUser.jsp").forward(request, response);
            	}
            		return mapping.findForward("error");
	}	
}