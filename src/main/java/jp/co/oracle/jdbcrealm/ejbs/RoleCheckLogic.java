package jp.co.oracle.jdbcrealm.ejbs;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author Yoshio Terada
 */
@Stateless
public class RoleCheckLogic {

    @RolesAllowed("admin")
    public String executableByAdmin() {
        return "管理者による実行が可能なロジック";
    }

    @RolesAllowed("user")
    public String executableByUser() {
        return "ユーザによる実行が可能なロジック";
    }

}
