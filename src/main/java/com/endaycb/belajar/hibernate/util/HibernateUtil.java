/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author mashiro
 */
public class HibernateUtil {
    
    /*private static SessionFactory sessionFactory;
    
    public static SessionFactory buildSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }*/
    
    public static Session openSession(){
        return new Configuration().configure().buildSessionFactory().openSession();
    }
}
