package com.ute.newsproject.controllers;

import com.ute.newsproject.utils.ServletUtils;
import com.ute.newsproject.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/Home/*")
public class HomeServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getPathInfo();
    if (path == null || path.equals("/")) {
      path = "/Index";
    }

    switch (path) {
      case "/Index":
        // HttpSession session = request.getSession();
        // System.out.println(session.getAttribute("auth"));
        // System.out.println(session.getAttribute("authUser"));

        ServletUtils.forward("/views/vwHome/Index.jsp", request, response);
        break;
      case "/About":
        ServletUtils.forward("/views/vwHome/About.jsp", request, response);
        break;
      default:
        ServletUtils.forward("/views/404.jsp", request, response);
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
