/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.dao;

import com.endaycb.belajar.model.User;
import com.endaycb.belajar.hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */
public class UserDao {
    Session session;
    
    
    public List<User> getAll(){
        List<User> listUser = new ArrayList<User>();
        
        session = HibernateUtil.openSession();
        
        Transaction transaction = null;
        try{
            transaction = session.getTransaction();
            transaction.begin();
            
            listUser = session.createQuery("FROM User").list();
            
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
        
        return listUser;
    }
    
    public User getById(Long id){
        User user = null;
        
        session = HibernateUtil.openSession();
        
        Transaction transaction = null;
        
        try{
            transaction = session.getTransaction();
            transaction.begin();
            
            Query query = session.createQuery("FROM User user WHERE user.id = :userId");
            query.setParameter("userId", id);
            
            user =  (User) query.uniqueResult();
            
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
        
        return user;
    }
    
    public User getByUsername(String username){
        
        User user = null;
        
        session = HibernateUtil.openSession();
        
        Transaction transaction = null;
        
        try{
            transaction = session.getTransaction();
            transaction.begin();
            
            Query query = session.createQuery("FROM User user WHERE user.username = :username");
            query.setString("username", username);
            
            user = (User) query.uniqueResult();
            
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            
            ex.printStackTrace();
        }finally{
            session.close();
        }
        
        return user;
    }
    
    public void save(User user){
        session = HibernateUtil.openSession();
        
        if(getByUsername(user.getUsername()).getUsername().isEmpty()){
            return;
        }
        
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            
            System.out.println(user.getId());
            session.save(user);
            
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
    
    public void delete(Long id){
        session = HibernateUtil.openSession();
        
        Transaction transaction = null;
        
        try{
            transaction = session.getTransaction();
            
            transaction.begin();
            
            User user = new User();

            user.setId(id);
            session.delete(user);
            
            transaction.commit();
        }catch(Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
}




