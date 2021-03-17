package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.form.ResetPasswordForm;
import com.handler.ResetPasswordHandler;

public class ResetPasswordAction extends Action  {
	@Override 
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

            	ResetPasswordForm resetPasswordForm=(ResetPasswordForm) form;

            	System.out.println(resetPasswordForm.getNewPassword()+" "+resetPasswordForm.getConfirmPassword());

            	if(!resetPasswordForm.getNewPassword().equals(resetPasswordForm.getConfirmPassword())){
            		request.setAttribute("passwordStatus","mismatch");
            		request.getRequestDispatcher("/resetPassword.jsp").forward(request,response);
            	}
       
             	HttpSession session=request.getSession();
            	String userName=(String) session.getAttribute("userName");
            	System.out.println("session user name is"+userName);
            	String status=ResetPasswordHandler.resetPassword(resetPasswordForm.getNewPassword(),resetPasswordForm.getConfirmPassword(),userName);
            	if(status.equals("success"))
				{
            		response.sendRedirect("http://localhost:8080/Struts/");
				}

            	return mapping.findForward("error");
            	}
            }