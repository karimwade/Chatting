<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <link type="text/css" rel="stylesheet" href="css/inscription.css"/> 
<%@ include file="dependance.jsp" %> 
<meta charset="utf-8" />
<title>Inscription</title>
</head>
<body> 
  <div class="col-md-12">
     <div class="loginBox bg-light">
          <h3>S'inscrire</h3>
           <c:if test="${ !empty form.resultat}">
			    <p><c:out value="${ form.resultat }" /></p>
		   </c:if>
		    <form method="post">
		        <div class="inputBox"> <input type="text" name="nom" placeholder="Nom" > </div>
		        <div class="inputBox"> <input type="text" name="prenom" placeholder="Prenom"> </div>
		        <div class="inputBox"> <input type="text" name="telephone" placeholder="Téléphone"> </div>
		        <div class="inputBox"> <input type="email" name="email" placeholder="Email"> </div>
		        <div class="inputBox"> <input type="text" name="login" placeholder="Login" > </div> 
		        <div class="inputBox"> <input type="password" name="password" placeholder="Password" > </div><input type="submit"  value="S'inscrire">
		      
		    </form> <a href="/chatting/login">Se connecter</a>
	</div>
 </div>

</body>
</html>