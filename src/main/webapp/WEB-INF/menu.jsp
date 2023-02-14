<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="dependance.jsp" %> 
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-5">
  <div class="col-md-12">
    <div class="row">
        <div class="col-md-4">
            <!-- Brand -->
            <a class="navbar-brand" href="#">Chatting be different</a>

        </div>
        <div class="col-md-6">

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="sujet">Sujet</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="discussion">Discussion</a>
                </li>
            </ul>
        </div>
        <div class="col-md-2 float-right text-white">
            <a class="">${ sessionScope.prenom }</a>
            <a class="btn  btn-info" href="login">Deconnecter</a>
        </div>
    </div>
</div>
</nav>