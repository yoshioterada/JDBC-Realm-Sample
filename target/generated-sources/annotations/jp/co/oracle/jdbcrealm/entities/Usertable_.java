package jp.co.oracle.jdbcrealm.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jp.co.oracle.jdbcrealm.entities.Grouptable;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-12-06T13:52:21")
@StaticMetamodel(Usertable.class)
public class Usertable_ { 

    public static volatile SingularAttribute<Usertable, String> username;
    public static volatile SingularAttribute<Usertable, String> password;
    public static volatile SingularAttribute<Usertable, String> mailaddress;
    public static volatile CollectionAttribute<Usertable, Grouptable> grouptableCollection;

}