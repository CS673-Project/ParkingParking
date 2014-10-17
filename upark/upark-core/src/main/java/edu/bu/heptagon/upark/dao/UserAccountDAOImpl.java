package edu.bu.heptagon.upark.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.bu.heptagon.upark.entities.UserAccount;

@Repository
public class UserAccountDAOImpl implements UserAccountDAO{
	@Autowired
    private SessionFactory sessionFactory;
    
	String queryHQL ＝ "from useraccount where useraccount.username =:inputUsername";
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addUserAccount(UserAccount ua) {
        getCurrentSession().save(ua);
    }
 
    public void updateUserAccount(UserAccount ua) {
        UserAccount uaupdate = getUserAccount(ua.getId());
        uaupdate.setPassword(ua.getPassword());
        uaupdate.setUsername(ua.getUsername());
        getCurrentSession().update(uaupdate);
 
    }
    public UserAccount findUserbyName(String username){
    	return getCurrentSession().createQuery(queryHQL).setString("inputUsername",username);
   
    	
    }
 
    public UserAccount getUserAccount(UUID id) {
        UserAccount ua = (UserAccount) getCurrentSession().get(UserAccount.class, id);
        return ua;
    }
 
    public void deleteAccount(UUID id) {
        UserAccount ua= getUserAccount(id);
        if (ua!= null)
            getCurrentSession().delete(ua);
    }
}
