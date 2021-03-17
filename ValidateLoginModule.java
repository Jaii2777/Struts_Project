package jaasAuth;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class ValidateLoginModule implements LoginModule { 
    private Subject subject;
    private CallbackHandler callbackHandler;
    private boolean success = false;
    private String username = null;
    private char[] password = null;
	private String otp=null;
    private UserPrincipal userPrincipal = null;
    private RolePrincipal rolePrincipal =null; 
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler,
                Map<String, ?> sharedState, Map<String, ?> options) {

        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }
 
    @Override
    public boolean login() throws LoginException {
   
        if (callbackHandler == null){
            throw new LoginException("No CallbackHandler available");
        }
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("username");
        callbacks[1] = new PasswordCallback("password: ", false);
        try {
            callbackHandler.handle(callbacks);
            username = ((NameCallback)callbacks[0]).getName();
            password = ((PasswordCallback)callbacks[1]).getPassword();
            if (isValidUser()){	
				
					success=true;
					System.out.println("tes");
					return true;
			}
        } catch (IOException e) { 
             e.printStackTrace();
        } catch (UnsupportedCallbackException e) {
             e.printStackTrace();
        }
        return false;
    }
 
    @Override
    public boolean commit() throws LoginException {
        if (success == false) {
            return false;
        } else { 
				userPrincipal = new UserPrincipal(username);
                subject.getPrincipals().add(userPrincipal);
				String role = getRole();
                RolePrincipal rolePrincipal = new RolePrincipal(role);
                subject.getPrincipals().add(rolePrincipal); 
                }
				return true;
	}
       
 
   @Override
   public boolean abort() throws LoginException {
      if (success == false) {
          return false;
      }
      return true;
   }
 
    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(userPrincipal);
        success = false;
        userPrincipal = null;
        return true;
   }
   
	private boolean isValidUser() throws LoginException {
      Connection con = null;
      ResultSet rs = null;
      PreparedStatement stmt = null;
      try {
          con = getConnection();
		  String sql = "select userId from userdetails where userName=?  and password=?";
          stmt = con.prepareStatement(sql);
          stmt.setString(1, username);
          stmt.setString(2, new String(password));
          rs = stmt.executeQuery();
    
          if (rs.next()) { 
			rs.close();
				stmt.close();
				con.close();
				return true;
		  }
			else{
				rs.close();
				stmt.close();
				con.close();
			}
       } catch (Exception e) {
           e.printStackTrace();
       }
	   return false;
       }
  private String getRole() { 
 
       return "user";
 }
  private Connection getConnection() throws LoginException {
      Connection con = null;
      try {
         con = DriverManager.getConnection ("jdbc:mysql://localhost/struts","root", "root");
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      return con;
   }
}