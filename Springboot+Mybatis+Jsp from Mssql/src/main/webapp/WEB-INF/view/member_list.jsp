<%@ page import="java.util.List" %>
<%@ page import="com.spring.Springboot.vo.Vo_member" %>
<%@ page import="com.spring.Springboot.vo.Vo_study" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-04-22
  Time: 오후 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Vo_member> list = (List<Vo_member>) request.getAttribute("list");
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
<body>

<!-- 헤더 위치 -->
<%@ include file="/WEB-INF/view/comm/header.jsp"%>

<main>
    <div class="container">
        <button type="button" onclick="location.href='/member/insert'" style="color: red; float: right; font-weight: bold">등록하기</button><br><br><br>
        <div class="row mb-2">
            <div class="col">아이디</div>
            <div class="col">이름</div>
            <div class="col">권한</div>
            <div class="col">등록일자</div>
            <div class="col">회원수정</div>
            <div class="col">회원삭제</div>
        </div>

        <%  for(Vo_member vo_member : list){  %>
        <div class="row mb-2">
            <div class="col"><%= vo_member.getMember_id() %></div>
            <div class="col"><%= vo_member.getName() %></div>
            <div class="col"><%= vo_member.getRole() %></div>
            <div class="col"><%= vo_member.getReg_day() %></div>
            <div class="col"><a href="/member/modify?member_id=<%= vo_member.getMember_id()%>">수정</a></div>
            <div class="col"><a href="/member/delete?member_id=<%= vo_member.getMember_id()%>">삭제</a></div>
        </div>
        <% } %>

    </div>

</main>

<!-- 푸터 위치 -->
<%@ include file="/WEB-INF/view/comm/footer.jsp"%>


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