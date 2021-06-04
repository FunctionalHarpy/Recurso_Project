<jsp:include page="menu.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitud</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
	<style>
		.modal-header{
			color:#fff;
			background: #428bca;
			display: flex;
	  		justify-content: center;
	  		
		}
		.help-block {
		  		color: red;
		}
		.form-group.has-error .form-control-label {
		  color: red;
		}
		.form-group.has-error .form-control {
		  border: 1px solid red;
		  box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
		}
	</style>


</head>
<body>




	<div class="container">
	<c:if test="${requestScope.MENSAJE!=null}">
	  		<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>${requestScope.MENSAJE}</strong>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
  		</c:if>
	<h1>Lista de Solicitudes</h1>	
			<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
		Registrar Solicitud
		</button>
		<br>
		<br>
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">Registro de Solicitud</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <form id="formSolicitud"  action="ServletSolicitud?ACCION=GUARDAR" method="post">
		      	<div class="form-row">
			      	<div class="form-group col-md-4">
				      <label>Cod Solicitud</label>
				      <input type="text" class="form-control" name="codSolicitud" value="0" readonly>
				    </div>
				    	<div class="form-group col-md-4">
				      <label>cod Usuario</label>
				      <input type="text" class="form-control" name="codUsuario">
				    </div>
			     	<div class="form-group col-md-4">
				      <label>Cod Area</label>
				      <input type="text" class="form-control" name="codArea">
				    </div>
		     	 </div>
		     	 <div class="form-row">
			     	 <div class="form-group col-md-5">
					      <label>Fecha</label>
					      <input type="date" class="form-control" name="fecha">
					 </div>
					 <div class="form-group col-md-7">
					      <label>Cod Informe</label>
					      <input type="text" class="form-control" name="codInforme">
					 </div>
				 	</div>
				 	<div class="form-group">
					    <label>Perfil</label>
					    <input type="text" class="form-control" name="perfil">
					</div>
				  <div class="mb-3">
				    <label>Descripción</label>
				    <textarea class="form-control" name="descripcion"></textarea>
				  </div>
				  <div class="modal-footer">
			       <button type="submit" class="btn btn-primary">Registrar</button>
			       <button type="button" class="btn btn-secondary" data-dismiss="modal" id="btn-cerrar">Cerrar</button>
		      	</div>
				 </form>
		      </div>
		      
		    </div>
		  </div>
		</div>	
		<!--TABLA -->
			<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>CÓDIGO</th>
                <th>COD USUARIO</th>
                <th>COD AREA</th>
                <th>COD INFORME</th>
                <th>FECHA</th>
                <th>PERFIL</th>
                <th>DESCRIPCION</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach items="${requestScope.solicitud}" var="row">
            <tr>
                <td>${row.cod_soli}</td>
                <td>${row.cod_user}</td>
                <td>${row.cod_area}</td>
                <td>${row.cod_informe}</td>
                <td>${row.fec_info}</td>
                <td>${row.perfil_soli}</td>
                <td>${row.descri_soli}</td>
                <td><button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modalSolicitud">Editar</button></td>
	            <td><button type="button" class="btn btn-danger btn-eliminar" data-toggle="modal" data-target="#modalEliminar">Eliminar</button></td>
            </tr>
         </c:forEach>
        </tbody>
        <tfoot>
            <tr>
               <th>CÓDIGO</th>
                <th>COD USUARIO</th>
                <th>COD AREA</th>
                <th>COD INFORME</th>
                <th>FECHA</th>
                <th>PERFIL</th>
                <th>DESCRIPCION</th>
            </tr>
        </tfoot>
    </table>
    
    <!-- INICIO - Modal PARA ELIMINAR Solicitud-->
		<div class="modal fade" id="modalEliminar" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">SISTEMA</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form id="formSolicitud"  action="ServletSolicitud?ACCION=ELIMINAR" method="post">
		         	    <input type="hidden" class="form-control" id="idCodigoEliminar" name="codigoEliminar">
				  SEGURO DE ELIMINAR ?
				  <div class="modal-footer">
			        <button type="submit" class="btn btn-primary">SI</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>			        
			      </div>
				</form>
		      </div>
		      
		    </div>
		  </div>
		</div>
  		<!-- FIN - Modal PARA ELIMINAR Solicitud-->  
    
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>
	
<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>





  


</body>
</html>