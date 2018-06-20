<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 08.06.2018
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"/>
<%--<fmt:setLocale value="pl_PL"/>--%>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="labels"/>
<html>
<head>
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
    <title>Anty News</title>
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

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Be Anty</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span
                        class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Page 1-1</a></li>
                        <li><a href="#">Page 1-2</a></li>
                        <li><a href="#">Page 1-3</a></li>
                    </ul>
                </li>
                <li><a href="#">Page 2</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Zarejestruj się</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
            </ul>
        </div>
    </nav>

    <div class="row">
        <div class="col-lg-3">

        </div>
        <div class="col-lg-6">
            <div class="thumbnail">
                <a href="http://localhost:8080/article/${articles[0].id}"><img class="card-img-top"
                                                                               src="${articles[0].img}"
                                                                               alt="Card image">
                    <p class="card-title">
                    <h3>${articles[0].tittle}</h3> ${fn:substring(articles[0].content,0,240)}...</p>
                </a>
            </div>
            <br>
            <div class="row">
                <c:forEach items="${articles}" var="article" begin="1">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="http://localhost:8080/article/${article.id}"><img class="card-img-top"
                                                                                       src="${article.img}"
                                                                                       alt="Card image cap">
                                <p class="card-title">${article.tittle}</p></a>
                            <div class="caption">${fn:substring(article.content,0,80)}...</div>
                        </div>
                    </div>
                    <br>
                </c:forEach>
            </div>
        </div>
    </div>


    <div class="footer">
        <div class="contact">
            <!-- Trigger the modal with a button -->
            <button type="button" class="btn btn-info btn-lg" id="contactbutton" data-toggle="modal"
                    data-target="#myModal"><i class="icon-email"></i></button>
            <!-- Modal -->
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <form class="form-horizontal" action="/antynews/contact" method="post">
                            <fieldset>
                                <legend class="text-center">Kontakt z nami!</legend>
                                <!-- Name input-->
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="name">Imię i nazwisko</label>
                                    <div class="col-md-9">
                                        <input id="name" name="name" type="text" placeholder="Imię i nazwisko"
                                               class="form-control">
                                    </div>
                                </div>
                                <!-- Email input-->
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="email">Twój adres e-mail</label>
                                    <div class="col-md-9">
                                        <input id="email" name="email" type="text" placeholder="Twój adres e-mail"
                                               class="form-control">
                                    </div>
                                </div>
                                <!-- Message body -->
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="message">Twoja wiadomość</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" id="message" name="message"
                                                  placeholder="Proszę wprowadź Twoją wiadomość tutaj..."
                                                  rows="5"></textarea>
                                    </div>
                                </div>
                                <!-- Form actions -->
                                <div class="form-group">
                                    <div class="col-md-12 text-right">
                                        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
