package jp.co.oracle.jdbcrealm.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Yoshio Terada
 */
@Entity
@Table(name = "USERTABLE")
@NamedQueries({
    @NamedQuery(name = "Usertable.findAll", query = "SELECT u FROM Usertable u"),
    @NamedQuery(name = "Usertable.findByUsername", query = "SELECT u FROM Usertable u WHERE u.username = :username"),
    @NamedQuery(name = "Usertable.findByMailaddress", query = "SELECT u FROM Usertable u WHERE u.mailaddress = :mailaddress"),
    @NamedQuery(name = "Usertable.findByPassword", query = "SELECT u FROM Usertable u WHERE u.password = :password")})
public class Usertable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "MAILADDRESS")
    private String mailaddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usertable")
    private Collection<Grouptable> grouptableCollection;

    public Usertable() {
    }

    public Usertable(String username) {
        this.username = username;
    }

    public Usertable(String username, String mailaddress, String password) {
        this.username = username;
        this.mailaddress = mailaddress;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMailaddress() {
        return mailaddress;
    }

    public void setMailaddress(String mailaddress) {
        this.mailaddress = mailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Grouptable> getGrouptableCollection() {
        return grouptableCollection;
    }

    public void setGrouptableCollection(Collection<Grouptable> grouptableCollection) {
        this.grouptableCollection = grouptableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertable)) {
            return false;
        }
        Usertable other = (Usertable) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.oracle.websocket.mailer.entities.Usertable[ username=" + username + " ]";
    }
    
}
