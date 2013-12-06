package jp.co.oracle.jdbcrealm.cdis;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jp.co.oracle.jdbcrealm.ejbs.UserRegistManager;

/**
 *
 * @author tyoshio2002
 */
@Named(value = "registPage")
@RequestScoped
public class RegistPage {
    private String username;
    private String mailaddress;
    private String password;
    private String group;
    @EJB
    UserRegistManager userRegist;

    /*
    DB へユーザ情報・グループ情報の登録
    */
    
    public String registDB() throws IOException {
        userRegist.createUserAndGroup(getUsername(),getMailaddress(), getPassword(), getGroup());
        return "reg-success";
    }

    /**
     * Creates a new instance of RegistPage
     */
    public RegistPage() {
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
     * @return the mailaddress
     */
    public String getMailaddress() {
        return mailaddress;
    }

    /**
     * @param mailaddress the mailaddress to set
     */
    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
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

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }
    
}
