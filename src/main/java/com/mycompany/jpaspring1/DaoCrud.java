/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpaspring1;

import com.mycompany.jpaspring1.entities.ContactsInfo;
import com.mycompany.jpaspring1.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import org.springframework.orm.jpa.JpaCallback;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import org.springframework.orm.jpa.JpaTemplate;

/**
 *
 * @author shibo
 *
 */
public class DaoCrud implements DaoInt {
    
    private TransactionTemplate transactionTemplate;
    private JpaTemplate jpaTemplate;
    
    public JpaTemplate getJpaTemplate() {
        return jpaTemplate;
    }
    
    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }
    
    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }
    
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
    
    @Override
    public boolean addUser(final User user) {

//        transactionTemplate.execute(new TransactionCallback() {
//
//            @Override
//            public User doInTransaction(TransactionStatus ts) {
//
//                hibernateTemplate.save(user);
//                return user;
//            }
//        });
        transactionTemplate.execute(new TransactionCallback<User>() {
            
            @Override
            public User doInTransaction(TransactionStatus ts) {
                jpaTemplate.persist(user);
                return user;
            }
        });

        //.save(user);
        return true;
    }
    
    @Override
    public User loginUser(User user) {
        
        User loginedUser = null;
        String sql = "from User p where p.userEmail=:email and p.userpass=:pass";
        //  Query query =sessionFactory.openSession().createQuery(sql);
//        query.setParameter("email", user.getUserEmail());
//        query.setParameter("pass", user.getUserpass());
//        List<User> list = query.list();
//        if (query.list().size() > 0) {
//
//            loginedUser = list.get(0);
//            return loginedUser;
//        } else {
        return loginedUser;
        // }
    }
    
    @Override
    public boolean updateUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean DeactiveUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean addContact(User user, ContactsInfo contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean editContact(User user, ContactsInfo contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean deleteContact(User user, ContactsInfo contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<ContactsInfo> showContacts(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<ContactsInfo> searchContacts(User user, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
