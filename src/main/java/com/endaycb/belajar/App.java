package com.endaycb.belajar;

/**
 * Hello world!
 *
 */
import com.endaycb.belajar.dao.UserDao;
import com.endaycb.belajar.hibernate.util.HibernateUtil;
import com.endaycb.belajar.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class App 
{
    public static void main( String[] args )
    {
//        Session session =  HibernateUtil.openSession();
//        Transaction tx = session.beginTransaction();
//        
//        User user = new User("a", "b", "c", "d", "e", "f");
//        user.setId(new Long(1));
//        
//        session.save(user);
//        tx.commit();
//        session.close();

//        User user = new User("memek", "b", "c", "d", "e", "f");
//        user.setId(new Long(1));
        
//        UserDao userDao = new UserDao();
//        User user = userDao.getByUsername("e");
//        
//        System.out.println(user.getFirstName());
    }
}
