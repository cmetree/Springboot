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

<%
    List<Vo_study> list = (List<Vo_study>) request.getAttribute("list");
%>


<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Home!</title>
</head>
<body class="text-center" >


<!-- 헤더 위치 -->
<%@ include file="/WEB-INF/view/comm/header.jsp" %>

<%--철자 하나에 오류 항상 철자 조심--%>

<main>
    <div class="container"  >
        <button type="button" onclick="location.href='/study_reg/insert'" style="color: red; float: right; font-weight: bold">등록하기</button><br><br><br>
        <div class="row mb-2 ,text-center" style="font-weight: bold;" >
            <div class="col">KEY_ID</div>
            <div class="col">공부일자</div>
            <div class="col">공부 컨텐츠 </div>
            <div class="col">등록일자</div>
            <div class="col" style="color: red">수정하기</div>
            <div class="col" style="color: red">삭제하기</div><br><br>
        </div>

        <% for(Vo_study vo_study : list){ %>
            <div class="row mb-2,text-center">
                <div class="col"><%= vo_study.getKEY_ID() %></div>
                <div class="col"><%= vo_study.getSTUDY_DAY() %></div>
                <div class="col"><%= vo_study.getCONTENTS() %></div>
                <div class="col"><%= vo_study.getREG_DAY() %></div>
                <div class="col"><a href="/study_reg/modify?key_id=<%= vo_study.getKEY_ID()  %>">수정</a></div>
                <div class="col"><a href="/study_reg/delete?key_id=<%= vo_study.getKEY_ID()  %>">삭제</a></div>
<%--                                                            파라미터로 넘길 값  _key_id         --%>
            </div>
        <% } %>



    </div>

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