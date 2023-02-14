<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/mystyle2.css"/>
<%@ include file="menu.jsp" %> 
<title>Sujet</title>
</head>
<body>
    <div class="col-md-10 offset-md-1">
      <div class="row">
        <div class="col-md-8">
          <section class="content">
			    <div class="col-md-12">
			        <div class="panel panel-default" style="border-bottom:none !important;">
			            <div class="panel-body">
			                <h1>Liste des sujets</h1>
			                <div class="table-container">
			                    <table class="table table-filter">
			                        <tbody>
			                         <c:forEach var="sujet" items="${ sujets }">
			                            <tr >
			                                <td>
			                                    <div class="media"> 
			                                        <img width="30" height="30" class="rounded-circle" src="img/mouha.jpg" >
			                                        <div class="media-body ml-2">
			                                            <h4 class="title"> <c:out value="${ sujet.userprenom }"/> <c:out value="${ sujet.usernom }"/> 
			                                              <span class="float-right greenn"><a href="discussion?sujet=${ sujet.id }">(discuter)</a></span> 
			                                            </h4>
			                                            <p class="summary"> <c:out value="${ sujet.libelle }"/> </p>
			                                        </div>
			                                    </div>
			                                </td>
			                            </tr>
			                          </c:forEach>
			                        </tbody>
			                    </table>
			                </div>
			            </div>
			        </div>
			    </div>
			</section>

        </div>
        <div class="col-md-4">
          <div class="card">
             <div class="col-md-12 p-0">
              <div class="card-header">
                <h5 class="text-primary">Ajout d'un sujet</h5>
              </div>
              <div class="col-md-12 py-4">
                 <form method="post">
                  <div class="col-md-12">
                      <div class="form-group " >
                            <label class="p-0 m-1" > Libellé du sujet </label>
                            <input type="text"  class="form-control" name="libelle" id="libelle" >
                     </div>
                  </div>
                  <div class="col-md-12 text-center">
		                <button type="reset" class="btn btn-danger" >
		                   Annuler
		                </button>&nbsp;
		                <button type="submit" class="btn btn-success">
		                   Ajouter
		                </button>
                  </div>
               </form>   
              </div>
             </div>
          </div>
        </div>
      
      </div>
    </div>

</body>
</html>  