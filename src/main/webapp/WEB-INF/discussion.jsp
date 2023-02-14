<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link type="text/css" rel="stylesheet" href="css/mystyle2.css"/>
<%@ include file="menu.jsp" %>  
<title>Discussion</title>
</head>
<body>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-4">
           <div class="card">
	             <div class="card-header">
	               <div class="col-md-12 text-center">
	   				 <h5 class="text-primary">Liste des sujets</h5>
				   </div>
	             </div>
				<div class="col-md-12 py-2">
					<div class="box_content">
					    <ol class="rounded-list">
					        <li>
					            <ol>
					               <c:forEach var="sujet" items="${ sujets }">
					                   <li><a href="?sujet=${ sujet.id }"><c:out value="${ sujet.libelle }" /></a></li>
					               </c:forEach>
					            </ol>
					        </li>
					    </ol>
					</div>
				</div>
           </div>
        </div>
        <div class="col-md-6">
         <c:if test="${ empty currentsujet}">
            <div class="col-md-12 mt-4">
              <img  src="img/inscription.png" class="user-circle-img-detail"> 
            </div>
         </c:if>
           <c:if test="${ !empty currentsujet}">
<div class="col-md-12 carddiscuss">

<div class="col-md-12 p-0 mb-2">

</div>
  <div class="col-md-12 py-2 mymessage mb-2">
        <c:forEach var="current" items="${ currentsujet }">
           <h5 class="text-center text-white"><c:out value="${ current.libelle }" /></h5>
        </c:forEach>
  </div>

<div class="col-md-12 p-0">
    <form method="post">
       <!--   <div class="card-body pd-0"> -->
            <div class="publisher publisher-multi">
                <div class="flexbox bd mt-2">
                 <textarea class="publisher-input auto-expand mg-t-10 pd-l-15" rows="3"  cols="85" name="message"
                        placeholder="Votre commentaire"></textarea>  
 
                </div>

            </div>
            <div class="flexbox p-2 bg-light mb-2">
                    <div class="col-md-12">
                       <div class="col-md-2 offset-md-10">
                        <button class="btn btn-sm btn-success " type="submit">
                            &nbsp;commenter
                        </button>
                    </div>
                    </div>
                </div>
       <!-- </div> -->
    </form>
</div>
<div class="timeline p-4 block mb-4">
    <c:forEach var="discussion" items="${ discussions }">
        <div class="tl-item active"> 
        <div class="tl-dot b-warning"><a class="tl-author" data-abc="true"><span class="w-32 avatar circle"><img width="30" height="30" class="rounded-circle" src="img/mouha.jpg" alt="."></span></a></div>
        <div class="tl-content">
            <div class="text-primary"><c:out value="${ discussion.userprenom }" /> <c:out value="${ discussion.usernom }" /> </div>
            <div class="mt-2 mymessage pl-2 pr-2 py-2"><c:out value="${ discussion.message }" /></div>
            <!-- <div class="tl-date text-muted mt-1"> <fmt:formatDate type = "date" value = "${discussion.date}" /></div> -->
        </div>
       </div>
    </c:forEach>
</div>



</div>
</c:if>
        </div>

       <div class="col-md-2 bg-light p-0">
        <div class="containers">
          <div class="col-md-12 mt-80">
               <div class="card2 bg-white">
                <c:if test="${ !empty currentsujet}">
                  <div ><img src="img/mouha.jpg" alt="" class="rounded-circle img2"></div>
                </c:if>
                <div class="text-center ">
                 <c:forEach var="current" items="${ currentsujet }">
                      <p class="job">Posté par</p>
			          <p class="name"><c:out value="${ current.userprenom }" /> <c:out value="${ current.usernom }" /></p>
		         </c:forEach>
                </div>
            </div>
          </div>
        </div>
       </div>
      </div>
    </div>

</body>
</html>  