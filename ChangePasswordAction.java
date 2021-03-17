package com.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
 
import com.form.ChangePasswordForm;
import com.handler.ChangePasswordHandler;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.PrintWriter;
 
public class ChangePasswordAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
              

                ChangePasswordForm changePasswordForm=(ChangePasswordForm) form;
				
				
				//System.out.println("change password"+changePasswordForm.getQ1()+" "+changePasswordForm.getQ2() );	
				if(changePasswordForm.getQ1()==null && changePasswordForm.getQ2()==null )
					return mapping.findForward("success");
				System.out.println("change password"+changePasswordForm.getQ1()+" "+changePasswordForm.getQ2()+" "
				+changePasswordForm.getQ3());
				
				System.out.println(request.getUserPrincipal().getName());
				String userName=(String)request.getUserPrincipal().getName();
				String message="";
			if(!changePasswordForm.getQ2().equals(changePasswordForm.getQ3())) {
				message+="Your New pass word and confirm password mismatch";
				request.setAttribute("message",message);
				request.getRequestDispatcher("/changePassword.jsp").forward(request,response);
				//return mapping.findForward("mismatch");
			}
			
			String status=ChangePasswordHandler.changePassword(changePasswordForm.getQ1(),changePasswordForm.getQ2(),userName);
			System.out.println("Sttaus is" +status);
			if(status.equals("wrongOldPassword")) {
				message+="Please enter valid old password";
				request.setAttribute("message",message);
				request.getRequestDispatcher("/changePassword.jsp").forward(request,response);
				//return mapping.findForward("wrongpass");
			}
				message+="Your password is successfully changed";
				request.setAttribute("message",message);
				return mapping.findForward("changed");
                
              
                
                 // if(changePasswordForm.getNewPassword().equals(changePasswordForm.getConfirmPassword()) ) {
                 //    System.out.println("mis match");
                 //    return mapping.findForward("mismatch");
                 // }*/
                         

           //      // else if(changePasswordForm.getOldPassword()!=null && changePasswordForm.getNewPassword()!=null
           //      //         && changePasswordForm.getConfirmPassword()!=null ) {
           //      //         System.out.println("inside all.....");
           //      //        String result=ChangePasswordHandler.changePassword(changePasswordForm.getOldPassword(),changePasswordForm.getNewPassword(),changePasswordForm.getConfirmPassword());
           //      //    System.out.println("Result is"+result);
           //      //         if(result.equals("wrongOldPassword"))
           //      //             return mapping.findForward("wrongpass");
           //      //         else if(result.equals("changed"))
           //      //             return mapping.findForward("changed");
                        
           //      // }
               
                }
}
 
