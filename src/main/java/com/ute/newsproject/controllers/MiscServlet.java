package com.ute.newsproject.controllers;

import com.ute.newsproject.utils.ServletUtils;
import com.ute.newsproject.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MiscServlet", value = "/Misc/*")
@MultipartConfig(
  fileSizeThreshold = 2 * 1024 * 1024,
  maxFileSize = 50 * 1024 * 1024,
  maxRequestSize = 50 * 1024 * 1024
)
public class MiscServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path = request.getPathInfo();
    switch (path) {

      case "/Comment":
        ServletUtils.forward("/views/vwMisc/Comment.jsp", request, response);
        break;

      case "/delete":
        ServletUtils.forward("/views/vwMisc/delete.jsp", request, response);
        break;

      default:
        ServletUtils.forward("/views/vwProduct/404.jsp", request, response);
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String path = request.getPathInfo();
    switch (path) {
      case "/Comment":
        postEditor(request, response);
        break;

      default:
        ServletUtils.forward("/views/404.jsp", request, response);
        break;
    }

  }
  private void postEditor(HttpServletRequest request, HttpServletResponse response) throws
          ServletException, IOException {
    String cmt = request.getParameter("comment");
    System.out.println(cmt);

    ServletUtils.forward("/views/vwMisc/Comment.jsp", request, response);
  }
}

