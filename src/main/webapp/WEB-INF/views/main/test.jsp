<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 테스트 화면</title>
</head>
<body>
<script>
    var jsonMyList = '<%= request.getAttribute("jsonMyList") %>';
    var myList = JSON.parse(jsonMyList); // JSON 데이터를 JavaScript 배열로 변환
    console.log(myList);
    alert(myList.length);
</script>

</body>
</html>
