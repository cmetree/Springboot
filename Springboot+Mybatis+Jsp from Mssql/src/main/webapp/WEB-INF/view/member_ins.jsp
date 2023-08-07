<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.spring.Springboot.vo.Vo_study" %>


<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2023-07-25
  Time: 오후 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Home!</title>
</head>
<body class="text-center">


<!-- 헤더 위치 -->
<%@ include file="/WEB-INF/view/comm/header.jsp" %>


<main>

    <form name="frm_study_mod" action="/member/insert_exe" method="post">
        <h3><b># KEY_ID_숫자로 필! 수! 작성</b><br></h3>#name,role 문자로만.!.<br><br>
        <div>Mem_Id : <input type="text" name="member_Id" value="" > </div><br>
        <div>Name : <input type="text" name="name" value=""></div><br>
        <div>Role : <input type="text" name="role" value=""></div></p>
        <input type="submit" value="등록하기">
    </form>


</main>


<!-- 푸터 위치 -->
<%@ include file="/WEB-INF/view/comm/footer.jsp" %>


<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->


</body>
</html>