<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:useBean id="tags" scope="request" type="java.util.List<com.ute.newsproject.beans.Tag>"/>

<t:main>
  <jsp:body>
    <div class="card">
      <h4 class="card-header d-flex justify-content-between">
        Tags
        <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Tag/Add" role="button">
          <i class="fa fa-plus" aria-hidden="true"></i>
          Add Tag
        </a>
      </h4>
      <c:choose>
        <c:when test="${tags.size() == 0}">
          <div class="card-body">
            <p class="card-text">Không có dữ liệu.</p>
          </div>
        </c:when>
        <c:otherwise>
          <div class="card-body">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Tag</th>
                  <th>&nbsp;</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${tags}" var="c">
                  <tr>
                    <td>${c.tagID}</td>
                    <td>${c.val}</td>
                    <td class="text-right">
                      <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/Admin/Tag/Edit?id=${c.tagID}" role="button">
                        <i class="fa fa-pencil" aria-hidden="true"></i>
                      </a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </jsp:body>
</t:main>