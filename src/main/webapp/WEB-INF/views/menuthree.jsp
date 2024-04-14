<%--
  Created by IntelliJ IDEA.
  User: jks
  Date: 2024-04-14
  Time: 오전 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>수강신청조회</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>년도</th><th>학기</th><th>교과목명</th><th>교과구분</th><th>담당교수</th><th>학점</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${id_regist}">
            <tr>
                <td><c:out value="${item.year}"/></td>
                <td><c:out value="${item.semester}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.classification}"/></td>
                <td><c:out value="${item.professor}"/></td>
                <td><c:out value="${item.credit}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
