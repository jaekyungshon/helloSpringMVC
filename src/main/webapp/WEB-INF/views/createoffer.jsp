<%--
  Created by IntelliJ IDEA.
  User: jks
  Date: 2024-04-13
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
    <!-- Web Form-->
    <!--
    <form method="post" action="${pageContext.request.contextPath}/docreate">
        <table class="formtable">
            <tr>
                <td class="label">Name:</td>
                <td><input class="control" type="text" name="name"/></td>
            </tr>
            <tr>
                <td class="label">Email:</td>
                <td><input class="control" type="text" name="email"/></td>
            </tr>
            <tr>
                <td class="label">Offer:</td>
                <td><textarea class="control" rows="10" cols="10" name="text"> </textarea></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="새 제안"/></td>
            </tr>
        </table>
    </form> -->

    <!-- Web Form에 Data-Buffering 적용 : 태그 라이브러리 사용. -->
    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
        <table class="formtable">
            <tr>
                <td class="label">Name:</td>
                <td>
                    <sf:input class="control" type="text" path="name"/>
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="name" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">Email:</td>
                <td>
                    <sf:input class="control" type="text" path="email"/>
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="email" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">Offer:</td>
                <td>
                    <sf:textarea class="control" rows="10" cols="10" path="text" />
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="text" class="error"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="새 제안"/></td>
            </tr>
        </table>
    </sf:form>
    <!-- login.jsp에서는 명시적으로 token을 담는 태그를 적음. 그러나, 여기는 안적음. 와이?
    그 이유는 sf:form처럼 태그 라이브러리를 사용하는 경우, 알아서 토큰을 보내기 떄문이다.-->
</body>
</html>
