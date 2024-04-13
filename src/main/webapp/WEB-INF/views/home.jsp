<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <p>
      <a href="/helloSpringMVC/offers">아래 url과 동일</a>
      <br/>
      <a href="${pageContext.request.contextPath}/offers"> Show current offers </a>
      <br/>
      <a href="${pageContext.request.contextPath}/createoffer"> Add a new offer </a>
    </p>

    <!-- logout form : spring이 알아서 절차를 진행함 -->
    <!-- 만약, 로그인한 사용자가 있따면, 아래의 태그가 보여짐 -->
    <c:if test="${pageContext.request.userPrincipal.name != null}">
      <a href="javascript:document.getElementById('logout').submit()">Logout</a>
    </c:if>
    <form id="logout" action="<c:url value="/logout" />" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
  </body>
</html>
