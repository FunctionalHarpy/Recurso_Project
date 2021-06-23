<jsp:include page="menu.jsp"/>
<!-- referenciar libreria JSTL pata trabajar con la sub-libreria CORE-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
    <!-- link rel="stylesheet" href="css/bootstrap.min.css"-->
    
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
	<!-- Tryna add a datepicker -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- Datepicker CSS -->
<link rel="stylesheet" href="css/datepicker.css">


<title>Usuarios</title>
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
  	<h2 class="text-center">Listado de Usuarios</h2>	
  	<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalUsuario">
		  Nuevo Usuario
		</button>	
		<table id="tableUsuarios" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>CÓDIGO</th>
                <th>USUARIO</th>
                <th>CONTRASEÑA</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>FECHA DE NACIMIENTO</th>
                <th>CORREO</th>
                <th>DIRECCIÓN</th>
                <th>ESTADO</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        	<!-- en el atributo items permite recuperar el atributo "usuarios" que viene del ServletUsuario -->
        	<c:forEach items="${requestScope.usuarios}" var="row">
	            <tr>
	                <td>${row.codigo}</td>
	                <td>${row.login}</td>
	                <td>${row.clave}</td>
	                <td>${row.nombres}</td>
	                <td>${row.apellidos}</td>
	                <td>${row.fdn}</td>
	                <td>${row.correo}</td>
	                <td>${row.dire}</td>
	                <td>${row.estado}</td>
	                <td><button type="button" class="btn btn-info btn-editar" data-toggle="modal" data-target="#modalUsuario">Editar</button></td>
	                <td><button type="button" class="btn btn-danger btn-eliminar" data-toggle="modal" data-target="#modalEliminar">Eliminar</button></td>
	            </tr>
            </c:forEach>
 		</tbody>
    </table>
    <!-- INICIO - Modal PARA REGISTRAR Y ACTUALIZAR USUARIO-->
		<div class="modal fade" id="modalUsuario" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">Usuario</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form id="formUsuario"  action="ServletUsuario?ACCION=GUARDAR" method="post">
		         <div class="form-group">
				    <label for="exampleInputEmail1">Código</label>
				    <input type="text" class="form-control" id="idCodigo" name="codigo" value="0" readonly>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Username</label>
				    <input type="text" class="form-control" id="idUsername" name="username" placeholder="Ingresar nombre de usuario">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Password</label>
				    <input type="text" class="form-control" id="idPassword" name="password" placeholder="Ingresar contraseña">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Nombres</label>
				    <input type="text" class="form-control" id="idNombres" name="nombres" placeholder="Ingresar nombres">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Apellidos</label>
				    <input type="text" class="form-control" id="idApellidos" name="apellidos" placeholder="Ingresar apellidos">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Fecha de Nacimiento</label>
				    <input type="date" class="form-control"  id="idFdn" name="fdn" placeholder="Ingresar fecha de nacimiento">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Correo</label>
				    <input type="text" class="form-control" id="idCorreo" name="correo" placeholder="Ingresar correo electronico">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Direccion</label>
				    <input type="text" class="form-control" id="idDireccion" name="direccion" placeholder="Ingresar direccion">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Estado</label>
				    <select class="form-control" id="idEstado" name="estado">
				      <option value=" ">[Seleccione Estado]</option>
				    </select>
				  </div>				  
				  <div class="modal-footer">
			        <button type="submit" class="btn btn-primary">Guardar</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="btn-cerrar">Cerrar</button>			        
			      </div>
				</form>
		      </div>
		      
		    </div>
		  </div>
		</div>
  		<!-- FIN - Modal PARA REGISTRAR Y ACTUALIZAR USUARIO-->
  		
  		
		<!-- INICIO - Modal PARA ELIMINAR DOCENTE-->
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
		        <form id="formUsuario"  action="ServletUsuario?ACCION=ELIMINAR" method="post">
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
  		<!-- FIN - Modal PARA ELIMINAR DOCENTE-->  	
  		
  		
  		
  	</div>	
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js">
    <!--script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"--><!--/script-->
	<script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>


	<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
	<!-- Datepicker JS-->
<script src="js/datepicker.js"></script>
	<script>
		$(document).ready(function() {
		    $('#tableUsuarios').DataTable();
		    llenarEstado();
		    
		} );
		$(document).on("click",".btn-editar",function(){
			//variables
			var cod,log,pass,nom,ape,fdn,correo,dir,estado;
			//obtener valores de la fila actual según donde se haga clic al botón editar
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			log=$(this).parents("tr").find("td")[1].innerHTML;
			pass=$(this).parents("tr").find("td")[2].innerHTML;
			nom=$(this).parents("tr").find("td")[3].innerHTML;
			ape=$(this).parents("tr").find("td")[4].innerHTML;
			fdn=$(this).parents("tr").find("td")[5].innerHTML;
			correo=$(this).parents("tr").find("td")[6].innerHTML;
			dir=$(this).parents("tr").find("td")[7].innerHTML;
			estado=$(this).parents("tr").find("td")[8].innerHTML;
			
			//mostrar los valores de las variables en los controles(cajas y select)
			$("#idCodigo").val(cod);
			$("#idUsername").val(log);
			$("#idPassword").val(pass);
			$("#idNombres").val(nom);
			$("#idApellidos").val(ape);
			$("#idFdn").val(fdn);
			$("#idCorreo").val(correo);
			$("#idDireccion").val(dir);
			$("#idEstado").val(estado);
			
		})
		
		//asignar evento click a los botones con clase "btn-eliminar"
		$(document).on("click",".btn-eliminar",function(){
			//variables
			var cod;
			//obtener código de la fila actual según donde se haga clic al botón editar
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			//
			$("#idCodigoEliminar").val(cod);
		
		})
		//asignar evento click al botón con ID "btn-cerrar"
		$(document).on("click","#btn-cerrar",function(){
			 //resetear validación 
			 $('#formUsuario'). data("bootstrapValidator").resetForm(true);
			 //limpiar cajas
			 $('#formUsuario').trigger("reset");
			 //asignar "0" a la caja con ID "idCodigo" 
			 $("#idCodigo").val(0);
		})
		
		//implementar función para llenar el select con ID "idEstado"
		function llenarEstado(){
			//función en JQUERY que permite leer un JSON
			/*
				la función getJSON tiene 3 parámetros:
				1. llamar al servlet "ServletCondicionJSON"	
				2. parámetro o parámetros que necesita el "ServletCondicionJSON", en este
					caso no existen parámetros debido a que no existe "request.getParameter"
				3. respuesta del "ServletEstadoJSON"	
			*/
			$.getJSON("ServletEstadoJSON",{},function(response){
				//bucle para realizar recorrido sobre "response"
				$.each(response,function(index,item){
					$("#idEstado").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
				})
				
			})
			
		}
	</script>	
	
	
	<script type="text/javascript">    
    $(document).ready(function(){ 
    	 $('#formUsuario').llenarFechas();
        $('#formUsuario').bootstrapValidator({      
        	 fields:{
        		 username:{
     		 		validators:{
     		 			notEmpty:{
     		 				message:'Campo nombre de usuario es obligatorio'
     		 			},
     		 			regexp:{
     		 				regexp:/^[a-zA-Z0-9_-]{3,15}$/,
     		 				message:'Campo nombre de usuario letras, digitos, guion y guion bajo (min 3 max 15)'
     		 			}
     		 		}
     		 	},
     		 	password:{
     		 		validators:{
     		 			notEmpty:{
     		 				message:'Campo contraseña es obligatorio'
     		 			},
     		 			regexp:{
     		 				regexp:/^[a-zA-Z0-9]{8,15}$/,
     		 				message:'Solo letras y digitos (min 8, max 15))'
     		 			}
     		 		}
     		 	},
        		 nombres:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo nombre es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\O\Ú]{3,15}$/,
        		 				message:'Campo nombre solo letras mínimo 3 y máximo 15'
        		 			}
        		 		}
        		 	},
        		 	apellidos:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo apellidos es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z\s\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\O\Ú]{3,15}$/,
        		 				message:'Campo apellido paterno solo letras mínimo 3 y máximo 15'
        		 			}
        		 		}
        		 	},
        		 	correo:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo correo es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z0-9-_@.]{8,50}$/,
        		 				message:'Ingrese una direccion de correo electronico valida'
        		 			}
        		 	
        		 		}
        		 	},
        		 	direccion:{
        		 		validators:{
        		 			notEmpty:{
        		 				message:'Campo direccion es obligatorio'
        		 			},
        		 			regexp:{
        		 				regexp:/^[a-zA-Z0-9' ',.-]{8,100}$/,
        		 				message:'Solo letras, digitos, guiones, comas y puntos'
        		 			}
        		 		}
        		 	},
        		 	
        		 	
        		 	
        		 	
        	 }
        });   
			
    }); 
	function llenarFechas(){
		$('[data-toggle="datepicker"]').datepicker({
		      autoHide: true,
		      zIndex: 2048,
		   })
	}
</script>
	
</body>
</html>