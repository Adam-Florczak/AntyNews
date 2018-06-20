<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 10.06.2018
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--TODO pobierz tytul z artykulu --%>

    <title>${article.tittle}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../public/css/styles.css">
    <link rel="stylesheet" type="text/css" href="../public/fontello/css/fontello.css">
    <%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="../public/img/news.jpg" style="float:left;">
        <span style="color:whitesmoke">Anty</span>News
        <div style="clear:both;"></div>
    </div>
</div>

<div class="container.fluid">


<div class="container">

    <div class="col-lg-3">

    </div>

    <div class = "col-md-6">
    <div class="column-header">
        <h5 style = "font-size:50px;">${article.tittle}</h5>
    </div>
    <div class="show-hide-column-image">
        <img src ="${article.img}">
    </div>
    <div class="text-center">
        ${article.content}
    </div>
    </div>
</div>

    <div class="footer">
        <div class="contact">
            <a href="../antynews/ContactPage.jsp"><i class="icon-email" ></i></a>
        </div>
    </div>

</body>
</html>

