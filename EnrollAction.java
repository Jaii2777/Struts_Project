package com.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
import com.form.EnrollForm;
import com.handler.EnrollHandler;

import javax.servlet.http.*;


 
public class EnrollAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EnrollForm enrollForm = (EnrollForm) form;
		String message="";
        if (enrollForm.getQ1() == null || enrollForm.getQ2() == null)
            return mapping.findForward("success");


        else if(enrollForm.getQ1() != null || enrollForm.getQ2() != null) {
        		EnrollHandler enrollHandler=new EnrollHandler();
				String userName=(String) request.getUserPrincipal().getName();
				System.out.println("username is"+userName);
        		String result=enrollHandler.enrollUser(enrollForm.getQ1(),enrollForm.getQ2(),userName);
        		if(result.equals("success")) {
        			message+="Enrolled successfully";
					request.setAttribute("message",message);
					request.getRequestDispatcher("/view.jsp").forward(request,response);
				}
        }
        		return mapping.findForward("error");
    }
}
 
