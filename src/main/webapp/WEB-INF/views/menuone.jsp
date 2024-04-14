<%--
  Created by IntelliJ IDEA.
  User: jks
  Date: 2024-04-14
  Time: 오전 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학년별 이수 학점 조회</title>
</head>
<body>
    <c:set var="total" value="0" />
    <table>
        <thead>
        <tr>
            <th>년도</th><th>학기</th><th>취득학점</th><th>상세보기</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${id_totalcredit}">
            <c:set var="total" value="${total + item.totalCredit}" />
            <tr>
                <td><c:out value="${item.year}"/></td>
                <td><c:out value="${item.semester}"/></td>
                <td><c:out value="${item.totalCredit}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/menuonedetails?year=${item.year}&semester=${item.semester}"> 링크 </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <th>총계</th>
            <th> </th>
            <th><c:out value="${total}" /></th>
            <th> </th>
        </tr>
        </tfoot>
    </table>
</body>
</html>
