/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author prabh
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have been successfully logged out!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }

        String username = (String) session.getAttribute("username");
        if (username != null) {
            response.sendRedirect("home");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }
    
    

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if (
            username == null ||
            username.equals("") ||
            password == null ||
            password.equals("")
            ) {
            request.setAttribute("msg", "Empty credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        User user = (new AccountService()).login(username, password);
        
        if (user == null) {
            request.setAttribute("msg", "Incorrect credentials");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        
        response.sendRedirect("home");
        return;
    }
        
    }

   


