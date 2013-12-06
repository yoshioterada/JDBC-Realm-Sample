package jp.co.oracle.jdbcrealm.cdis;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yoshio Terada
 */
@Named(value = "indexPage")
@RequestScoped
public class IndexPage {

    private String username;
    private String password;

    /**
     * Creates a new instance of IndexPage
     */
    public IndexPage() {
    }

    /*
     既にログイン済みだった場合、ログイン後のページ(home.xhtml)へリダイレクトし
     login.xhtml を非表示
     */
    public void onPageLoad() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            try {
                StringBuilder redirectURL = new StringBuilder(request.getContextPath());
                redirectURL.append("/faces/login/home.xhtml");
                FacesContext.getCurrentInstance().getExternalContext().redirect(redirectURL.toString());
            } catch (IOException ex) {
                request.logout();
            }
        }
    }

    /*
     ログインボタンが押下された際の処理
     */
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            request.login(getUsername(), getPassword());
            return "home.xhtml?faces-redirect=true";
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ログインに失敗しました。", "ユーザ名、パスワードを正しく入力してください。"));
            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    /*
     ログアウトボタンが押下された際の処理
     */

    public String logout() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index.xhtml?faces-redirect=true";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
