/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endaycb.belajar.controller;

import com.endaycb.belajar.dao.UserDao;
import com.endaycb.belajar.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class UserController extends HttpServlet{
    RequestDispatcher rd ;
    UserDao userDao = new UserDao();
    Boolean loggedIn;
    
    HttpServletRequest req;
    HttpServletResponse res;
    
    private final String urlLogin = "login.jsp";
    private final String urlHome = "home.jsp";
    private final String urlLoginError = "error.jsp";
    private final String urlRegister = "register.jsp";
    private final String urlLogout = "logout.jsp";
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doControll(req, res);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doControll(req, res);
    }
      
    private void doControll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        this.req = req;
        this.res = res;
        
        String action = req.getParameter("action");
        
        Boolean loggedIn = (Boolean) req.getSession().getAttribute("loggedIn");
        
        if(loggedIn!=null){
            
            if(action == null){
                res.sendRedirect(urlHome);
            }else{
                String urlRedirect = "";
                
                if(action == "register"){
                    urlRedirect = urlRegister;
                }else if(action == "logout"){
                    urlRedirect = urlLogout;
                }
                
                rd = req.getRequestDispatcher(urlRedirect);
                rd.forward(req, res);
            }
        }else if(loggedIn == null && action.equals("doLogin") ){
           
            //login
            try{
                
                login(req.getParameter("username"), req.getParameter("password"));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            res.sendRedirect(urlLogin);
        }
    }
    
    private void login(String username, String password){
        User user = userDao.getByUsername(username);
        
        if(user.getPassword().equals(password)){
            try {
                req.getSession(true).setAttribute("loggedId", true);
                req.getSession(true).setAttribute("userData", user);
                
                res.sendRedirect(urlHome);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }else{
           try {
                res.sendRedirect(urlLoginError);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
}
