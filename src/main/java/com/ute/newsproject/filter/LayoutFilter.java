package com.ute.newsproject.filter;


import com.ute.newsproject.service.TagService;
import com.ute.newsproject.beans.Tag;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "LayoutFilter")
public class LayoutFilter implements Filter {
  public void init(FilterConfig config) throws ServletException {
  }

  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    List<Tag> list = TagService.findAll();
    request.setAttribute("categoriesWithDetails", list);

    chain.doFilter(request, response);
  }
}
