package jaasAuth;

import java.io.Serializable;
import java.security.Principal;
 

public class RolePrincipal implements Principal, Serializable {
    private String name;
	public RolePrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}