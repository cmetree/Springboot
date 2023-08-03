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
<body>


<!-- 헤더 위치 -->
<%@ include file="/WEB-INF/view/comm/header.jsp" %>


<main>
  <div class="px-4 py-5 my-5 text-center">
    <h1 class="display-5 fw-bold" style="color:red">SpringBoot+Mybatis+JSP <br>  from Mssql <br> for Study</h1><br>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4" ><h4 style="color:blue"><b>by Shim Kyu Tae</b></h4> <br>
      </p>
      Java 버전 : 1.8<br>
      프레임워크 : SpringBoot 2.6.6<br><br>
      DBMS : MsSql <br>
      View  : Jsp<br>
      Mapper : MyBatis<br> <br>
      개발툴 : IntelliJ IDEA<br>
    </div>
  </div>
</main>


<!-- 푸터 위치 -->
<%@ include file="/WEB-INF/view/comm/footer.jsp" %>>


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