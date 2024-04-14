<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 5주차 실습 내용 -->
<%--<html>--%>
<%--  <head>--%>
<%--    <title>$Title$</title>--%>
<%--  </head>--%>
<%--  <body>--%>
<%--    <p>--%>
<%--      <a href="/helloSpringMVC/offers">아래 url과 동일</a>--%>
<%--      <br/>--%>
<%--      <a href="${pageContext.request.contextPath}/offers"> Show current offers </a>--%>
<%--      <br/>--%>
<%--      <a href="${pageContext.request.contextPath}/createoffer"> Add a new offer </a>--%>
<%--    </p>--%>

<%--    <!-- logout form : spring이 알아서 절차를 진행함 -->--%>
<%--    <!-- 만약, 로그인한 사용자가 있따면, 아래의 태그가 보여짐 -->--%>
<%--    <c:if test="${pageContext.request.userPrincipal.name != null}">--%>
<%--      <a href="javascript:document.getElementById('logout').submit()">Logout</a>--%>
<%--    </c:if>--%>
<%--    <form id="logout" action="<c:url value="/logout" />" method="post">--%>
<%--      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--    </form>--%>
<%--  </body>--%>
<%--</html>--%>

<!-- Homework : 학사 정보 시스템 -->
<html>
  <head>
    <title>학사 정보 시스템</title>
  </head>
  <body>
    <!-- 로그인, 로그아웃 버튼 -->
    <div>
      <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="javascript:document.getElementById('logout').submit()">로그아웃</a>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a href="${pageContext.request.contextPath}/login">로그인</a>
      </c:if>
      <form id="logout" action="<c:url value="/logout" />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </div>

    <!-- 메뉴 -->
    <div>
      <p><a href="${pageContext.request.contextPath}/menuone"> 학년별 이수 학점 조회 </a></p>
      <p><a href="${pageContext.request.contextPath}/menutwo"> 수강 신청하기 </a></p>
      <p><a href="${pageContext.request.contextPath}/menuthree"> 수강 신청 조회 </a></p>
    </div>
  </body>
</html>