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
import org.apache.catalina.User;

/**
 *
 * @author prabh
 */
public class HomeServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("username");
        if (user == null){
            response.sendRedirect("login");
           return;
       
        }
       
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
       
            return;
        
    }
}

