<%--
  Created by IntelliJ IDEA.
  User: jks
  Date: 2024-04-14
  Time: 오전 7:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>수강 신청</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
    <sf:form method="post" action="${pageContext.request.contextPath}/domenutwo" modelAttribute="homeworkRegist">
        <table class="formtable">
            <tr>
                <td class="label">년도:</td>
                <td>
                    <sf:input class="control" type="text" path="year"/>
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="year" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">학기:</td>
                <td>
                    <sf:input class="control" type="text" path="semester"/>
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="semester" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">교과목명:</td>
                <td>
                    <sf:input class="control" type="text" path="name" />
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="name" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">교과구분:</td>
                <td>
                    <sf:input class="control" type="text" path="classification" />
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="classification" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">담당교수:</td>
                <td>
                    <sf:input class="control" type="text" path="professor" />
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="professor" class="error"/>
                </td>
            </tr>
            <tr>
                <td class="label">학점:</td>
                <td>
                    <sf:input class="control" type="text" path="credit" />
                    <br/>
                    <!-- 유효성 검사 실패 출력 공간 -->
                    <sf:errors path="credit" class="error"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="신청하기"/></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
