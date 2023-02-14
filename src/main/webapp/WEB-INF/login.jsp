<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
 <link type="text/css" rel="stylesheet" href="css/login.css"/>
<%@ include file="dependance.jsp" %> 
<title>Connection</title>
</head>
<body>
   <div class="col-md-12 p-0">
   <div class="limiter" id="login">
    <div class="container-login100" style="background-image:url(img/connection.png)">
        <div class="container">
            <div class="row">
                <div class="col-md-6"></div>
                <div class="col-md-5 col-md-offset-1">
                    <div class="login_topimg"> </div>
                    <div class="wrap-login100">
                        <form class="login100-form validate-form" method="post"> <span class="login100-form-title "> Connectez vous </span> <span class="login100-form-subtitle m-b-16"> à votre compte </span>
                            <div class="col-md-12 text-danger">
                                <c:if test="${ !empty form.resultat}"><p><c:out value="${ form.resultat }" /></p></c:if>
                            </div>
                            <div class="wrap-input100 validate-input m-b-16" > <input class="input100" type="text" name="login" placeholder="Login"> <span class="focus-input100"></span> <span class="symbol-input100"> <span class="glyphicon glyphicon-user"></span> </span> </div>
                            <div class="wrap-input100 validate-input m-b-16" > <input class="input100" type="password" name="password" placeholder="Mot de passe"> <span class="focus-input100"></span> <span class="symbol-input100"> <span class="glyphicon glyphicon-lock"></span> </span> </div>
                            <div class="flex-sb-m w-full p-b-30">
                               
                                <div> Pas encore de compte ? <a  href="/chatting/inscription" class="txt1"> S'inscrire </a> </div>
                            </div>
                            <div class="container-login100-form-btn p-t-25"> <button class="login100-form-btn" type="submit"> Se connecter </button> </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
   
  </div>
</body>
</html>