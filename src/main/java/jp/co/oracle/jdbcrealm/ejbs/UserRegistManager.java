package jp.co.oracle.jdbcrealm.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.co.oracle.jdbcrealm.SHADigestUtil.SHA256Encoder;
import jp.co.oracle.jdbcrealm.entities.Grouptable;
import jp.co.oracle.jdbcrealm.entities.GrouptablePK;
import jp.co.oracle.jdbcrealm.entities.Usertable;

/**
 *
 * @author Yoshio Terada
 */
@Stateless
public class UserRegistManager {

    @PersistenceContext
    EntityManager em;
    
    /*
    指定したユーザ、メールアドレス、パスワード、グループ名で
    DB へ登録
    */
    

    public void createUserAndGroup(String username,String mailaddress, String password, String groupname) {
        Usertable user = new Usertable();
        user.setUsername(username);
        user.setMailaddress(mailaddress);
        
        SHA256Encoder encoder = new SHA256Encoder();
        String encodedPassword = encoder.encodePassword(password);
        user.setPassword(encodedPassword);

        Grouptable group = new Grouptable();
        group.setGrouptablePK(new GrouptablePK(username, groupname));
        group.setUsertable(user);
        
        em.persist(user);
        em.persist(group);
    }
    /*
    DB から指定したユーザの削除
    */

    public void removeUser(String username) {
        Usertable user = em.find(Usertable.class, username);
        em.remove(user);
    }

    /*
    DB から指定したユーザの検索
    */
    
    public Usertable findUser(String username){
        Usertable user = em.find(Usertable.class, username);
        return user;
    }
}
