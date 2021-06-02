<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
/* Modify the background color */
          
          /* Modify the background color */
          
        .navbar-custom {
            background-color: #7c0000;
        }
        /* changing brand text color*/
.navbar-custom .navbar-brand,
.navbar-custom .navbar-text {
    color: #ffffff;
}
/* navigation link text color */
.navbar-custom .navbar-nav .nav-link {
    color: rgba(255,255,255,.6);
}
/* navigation links anchor hover and active styles */
.navbar-custom .nav-item.active .nav-link,
.navbar-custom .nav-item:hover .nav-link {
    color: #ffffff;
}
</style>
</head>
<body>
<div class="pos-f-t">
	<nav class="navbar navbar-custom navbar-expand-sm">
	  	  <div class="navbar-header">
		       <div class="navbar-header">
	     		 <a class="navbar-brand" href="#">INTRANET</a>
	  			</div>
	  	</div>
	  
	  <div class="collapse navbar-collapse">
		  <ul class="navbar-nav">
	
		   <c:forEach items="${sessionScope.MENUS}" var="bean">
			    <li class="nav-item">
			      <a class="nav-link" href="${bean.url}">${bean.nombre}</a>
			    </li>
			</c:forEach>
	
		    
		  </ul>
	
		  <div class="navbar-nav ml-auto">
		  		
		     	<span class="nav-item nav-link">
		     		${sessionScope.DATOS}
		     	</span>  
		     
		        <a href="ServletUsuario?ACCION=CERRAR" class="nav-item nav-link">Cerrar Sesi�n</a>
	      </div>
    </div>
	</nav>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script   src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>