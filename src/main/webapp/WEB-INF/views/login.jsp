<%--
  Created by IntelliJ IDEA.
  User: jks
  Date: 2024-04-13
  Time: 오후 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Custom 로그인 폼</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
  <!-- 아이디, 비밀번호 일치 여부절차는 spring이 자동 진행 -->
  <form class="form-signin" method="post" action="<c:url value="/login" />">
    <h2 class="form-signin-heading">Please sign in</h2>

    <!-- 아이디 또는 비밀번호 오류 메시지 출력칸 -->
    <c:if test="${not empty errorMsg}">
      <div style="color:#ff0000;"><h3> ${errorMsg} </h3></div>
    </c:if>
    <!-- 로그아웃 성공 메시지 출력칸 -->
    <c:if test="${not empty logoutMsg}">
      <div style="color:#0000ff;"><h3> ${logoutMsg} </h3></div>
    </c:if>
    <p>
      <label for="username" class="sr-only">Username</label>
      <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
    </p>
    <p>
      <label for="password" class="sr-only">Password</label>
      <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
    </p>
    <!-- CSRF Token -->
    <!-- 서버가 던져주는 Token을 클라이언트가 받아서 채운다. 35라인이 없다면, 서버가 승인 거부.-->
    <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  </form>
</div>
</body>
</html>
