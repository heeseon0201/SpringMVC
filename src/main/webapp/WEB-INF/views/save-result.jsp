<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li> <!-- request의 attribute에 담긴 데이터 조회-->
</ul>
<a href="/index.html">메인</a>
</body>
</html>