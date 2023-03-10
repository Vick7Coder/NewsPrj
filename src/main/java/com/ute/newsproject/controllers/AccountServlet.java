package com.ute.newsproject.controllers;


import com.ute.newsproject.beans.User;
import com.ute.newsproject.service.UserService;
import com.ute.newsproject.utils.ServletUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "AccountServlet", value = "/Account/*")
public class AccountServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getPathInfo();
    switch (path) {
      case "/Register":
        ServletUtils.forward("/views/vwAccount/Register.jsp", request, response);
        break;

      case "/Login":
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("auth")) {
          ServletUtils.redirect("/Home", request, response);
        } else ServletUtils.forward("/views/vwAccount/Login.jsp", request, response);
        break;

      case "/Profile":
        ServletUtils.forward("/views/vwAccount/Profile.jsp", request, response);
        break;

      case "/IsAvailable":
        String uName = request.getParameter("user");
        User user = UserService.findByUsername(uName);
        boolean isAvailable = (user == null);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        out.print(isAvailable);
        out.flush();
        break;

      default:
        ServletUtils.forward("/views/404.jsp", request, response);
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getPathInfo();
//    switch (path) {
//      case "/Register":
//        registerUser(request, response);
//        break;
//
//      case "/Login":
//        login(request, response);
//        break;
//
//      case "/Logout":
//        logout(request, response);
//        break;
//
//      default:
//        ServletUtils.forward("/views/404.jsp", request, response);
//        break;
//    }
  }

//  private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String rawpwd = request.getParameter("rawpwd");
//    String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());
//
//    String strDob = request.getParameter("dob") + " 00:00";
//    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//    LocalDateTime dob = LocalDateTime.parse(strDob, df);
//
//    String username = request.getParameter("username");
//    String name = request.getParameter("name");
//    String email = request.getParameter("email");
//    int permission = 0;
//
//    User c = new User(0, username, bcryptHashString, name, email, dob, permission);
//    UserModel.add(c);
//    ServletUtils.forward("/views/vwAccount/Register.jsp", request, response);
//  }
//
//  private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//
//    User user = UserModel.findByUsername(username);
//    if (user != null) {
//      BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
//      if (result.verified) {
//        HttpSession session = request.getSession();
//        session.setAttribute("auth", true);
//        session.setAttribute("authUser", user);
//        // response.addCookie(new Cookie("ecWebAppAuthUser", user.getUsername()));
//
//        String url = (String) session.getAttribute("retUrl");
//        if (url == null)
//          url = "/Home";
//        ServletUtils.redirect(url, request, response);
//      } else {
//        request.setAttribute("hasError", true);
//        request.setAttribute("errorMessage", "Invalid login.");
//        ServletUtils.forward("/views/vwAccount/Login.jsp", request, response);
//      }
//    } else {
//      request.setAttribute("hasError", true);
//      request.setAttribute("errorMessage", "Invalid login.");
//      ServletUtils.forward("/views/vwAccount/Login.jsp", request, response);
//    }
//  }

  private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    session.setAttribute("auth", false);
    session.setAttribute("authUser", new User());

    String url = request.getHeader("referer");
    if (url == null)
      url = "/Home";
    ServletUtils.redirect(url, request, response);
  }
}
