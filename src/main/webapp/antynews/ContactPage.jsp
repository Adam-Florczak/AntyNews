<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 12.06.2018
  Time: 19:42
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Page</title>
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
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="well well-sm">
                <form class="form-horizontal" action="/antynews/contact" method="post">
                    <fieldset>
                        <legend class="text-center">Kontakt z nami!</legend>

                        <!-- Name input-->
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="name">Imię i nazwisko</label>
                            <div class="col-md-9">
                                <input id="name" name="name" type="text" placeholder="Imię i nazwisko" class="form-control">
                            </div>
                        </div>

                        <!-- Email input-->
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="email">Twój adres e-mail</label>
                            <div class="col-md-9">
                                <input id="email" name="email" type="text" placeholder="Twój adres e-mail" class="form-control">
                            </div>
                        </div>

                        <!-- Message body -->
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="message">Twoja wiadomość</label>
                            <div class="col-md-9">
                                <textarea class="form-control" id="message" name="message" placeholder="Proszę wprowadź Twoją wiadomość tutaj..." rows="5"></textarea>
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
            <div class="content">
                <c:choose>
                    <c:when test="${succesfull}">
                        <p>${succesful}</p>
                    </c:when>
                    <c:when test="${unsuccesfull}">
                        <p>${unsuccesfull}</p>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>

</body>
</html>
