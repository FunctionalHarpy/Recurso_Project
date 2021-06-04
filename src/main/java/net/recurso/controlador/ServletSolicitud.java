package net.recurso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.recurso.entidad.Solicitud;
import net.recurso.services.SolicitudService;


@WebServlet("/ServletSolicitud")
public class ServletSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SolicitudService sSolicitud;
	
	
    public ServletSolicitud() {
    	super();
    	sSolicitud = new SolicitudService();

    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("ACCION");
		if(tipo.equals("LISTAR"))
			listado(request,response);
		else if (tipo.equals("GUARDAR"))
			guardar(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminar(request,response);
	}
	
	private void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Leer controles
		String codSoli,codUsu,codArea,fecha,codInfo,perfil,desc;
		codSoli=request.getParameter("codSolicitud");
		codUsu=request.getParameter("codUsuario");
		codArea=request.getParameter("codArea");
		fecha=request.getParameter("fecha");
		codInfo=request.getParameter("codInforme");
		perfil=request.getParameter("perfil");
		desc=request.getParameter("descripcion");
		
		//Crear Objeto de la clases Solicitud
		Solicitud bean = new Solicitud();
		
		//Asignado valor a los Atributos
		bean.setCod_soli(Integer.parseInt(codSoli));
		bean.setCod_user(Integer.parseInt(codUsu));
		bean.setCod_area(Integer.parseInt(codArea));
		bean.setCod_informe(Integer.parseInt(codInfo));
		bean.setFec_info(fecha);
		bean.setPerfil_soli(perfil);
		bean.setDescri_soli(desc);
		
		if(bean.getCod_soli()==0) {
			int salida;
			salida = sSolicitud.agregar(bean);
			if(salida>0) {
				request.setAttribute("MENSAJE","Solicitud registrada");
			}
			else {
				request.setAttribute("MENSAJE","Error en el registro de solicitud");
			}		
		}
		listado(request,response);
	}
	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al método listAll
		List<Solicitud> data= sSolicitud.listarTodos();
		//enviar al cliente la respuesta
		//PASO 1: crear un atributo
		request.setAttribute("solicitud", data);
		//PASO 2: direccionar a la página docente.jsp
		request.getRequestDispatcher("/solicitud.jsp").forward(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leer caja codigoEliminar
		String cod;
		cod=request.getParameter("codigoEliminar");
		//invocar al mètodo delete
		int salida;
		salida=sSolicitud.eliminar(Integer.parseInt(cod));
		//validar salida
		if(salida>0) {// SE ELIMINO CORRECTAMENTE
			//crear un atributo MENSAJE
			request.setAttribute("MENSAJE","Solicitud eliminada");
		}
		else {// ERROR AL ELIMINAR
			request.setAttribute("MENSAJE","Error al eliminar solicitud");
		}
		listado(request,response);
	}
	
	
	
	

}
