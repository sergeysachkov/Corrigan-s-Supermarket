package com.ait.corrigan.src.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ait.corrigan.dao.CustomerDao2;
import com.ait.corrigan.models.user.Customer;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/LoginServlet")
public class Loginservlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public Loginservlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TOD
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      Customer customer = CustomerDao2.instance.checkLogin(name, password);
      if (customer != null) {
         HttpSession session = request.getSession();
         session.setAttribute("customer", customer);
         request.getRequestDispatcher("index.jsp").forward(request, response);
      } else {
         request.getRequestDispatcher("login.jsp").forward(request, response);
      }
   }

}
