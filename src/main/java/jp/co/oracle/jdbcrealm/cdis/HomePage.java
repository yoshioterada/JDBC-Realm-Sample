package jp.co.oracle.jdbcrealm.cdis;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import jp.co.oracle.jdbcrealm.ejbs.RoleCheckLogic;

/**
 *
 * @author Yoshio Terada
 */
@Named(value = "homePage")
@RequestScoped
public class HomePage {

    /**
     * Creates a new instance of HomePage
     */
    public HomePage() {
    }

    @EJB
    RoleCheckLogic roleCheckLogic;

    private String roleChekerString;

    public String getRoleChekerString() {
        if (isUserInRole("admin")) {
            String adminRoleString = roleCheckLogic.executableByAdmin();
            roleChekerString = adminRoleString;
        }
        if (isUserInRole("user")) {
            String userRoleString = roleCheckLogic.executableByUser();
            roleChekerString = userRoleString;
        }
        return roleChekerString;
    }

    /*    
     ログインしたユーザが、引数で指定した役割（ロール）を持つ
     ユーザか否かを検証
     */
    public boolean isUserInRole(String role) {
        return FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role);
    }
}
