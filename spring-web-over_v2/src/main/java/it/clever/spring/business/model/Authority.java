package it.clever.spring.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_authorities")
public class Authority {
	public static final String ROLE_SUPERADMIN = "ROLE_SUPERADMIN";
	public static final String ROLE_BRANCH_CHOOSER = "ROLE_BRANCH_CHOOSER";
	
    @Id
    @Column(name = "role_name")
    private String roleName;
    
    @Column(name = "role_desc")
    private String roleDesc;
    
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String id) {
        this.roleName = id;
    }
    
    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    
    public String toString() {
        return roleDesc;
    }
    
}
