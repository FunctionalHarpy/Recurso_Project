package net.recurso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.recurso.entidad.Menu;
import net.recurso.entidad.Usuario;
import net.recurso.services.UsuarioService;


@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioService sUsuario;
	       
    
    public ServletUsuario() {
        super();
        sUsuario=new UsuarioService();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo;
		tipo=request.getParameter("ACCION");
		if(tipo.equals("INICIAR"))
			iniciar(request,response);
		else if(tipo.equals("LISTAR"))
			listado(request,response);
		else if(tipo.equals("CERRAR"))
			cerrar(request,response);
		else if(tipo.equals("GUARDAR"))
			guardar(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminar(request,response);
	}


	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod;
		cod=request.getParameter("codigoEliminar");
		int salida;
		salida=sUsuario.eliminar(Integer.parseInt(cod));
		if(salida>0) {
			request.setAttribute("MENSAJE", "Usuario eliminado");
		}
		else {
			request.setAttribute("MENSAJE", "Error al eliminar usuario");
		}
		listado(request, response);
		
	}


	private void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod, login, pass,nom, ape, fdn, email, dir, estado;
		cod=request.getParameter("codigo");
		login=request.getParameter("username");
		pass=request.getParameter("password");
		nom=request.getParameter("nombres");
		ape=request.getParameter("apellidos");
		fdn=request.getParameter("fdn");
		email=request.getParameter("correo");
		dir=request.getParameter("direccion");
		estado=request.getParameter("estado");
		//
		Usuario bean = new Usuario();
		//
		bean.setCodigo(Integer.parseInt(cod));
		bean.setLogin(login);
		bean.setClave(pass);
		bean.setNombres(nom);
		bean.setApellidos(ape);
		bean.setFdn(fdn);
		bean.setCorreo(email);
		bean.setDire(dir);
		bean.setEstado(Integer.parseInt(estado));
		//
		if (bean.getCodigo()==0) {//insert
			int salida;
			salida=sUsuario.agregar(bean);
			if(salida>0) {
				request.setAttribute("MENSAJE", "Usuario registrado");
				
			}
			else {
				request.setAttribute("MENSAJE", "Error al registrar usuario");
			}
			
		}
		else {//update
			int salida;
			salida=sUsuario.actualizar(bean);
			if (salida>0) {
				request.setAttribute("MENSAJE", "Usuario actualizado");
				
			}else {
				request.setAttribute("MENSAJE", "Error al actualizar usuario");
			}
			
		}
		listado(request,response);
			
		
	}


	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al método listAll
				List<Usuario> data=sUsuario.listarTodos();
				//enviar al cliente la respuesta
				//PASO 1: crear un atributo
				request.setAttribute("usuarios", data);
				//PASO 2: direccionar a la página docente.jsp
				request.getRequestDispatcher("/usuarios.jsp").forward(request, response);
		
	}


	private void cerrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("MENSAJE", "Sesión cerrada");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}


	
	private void iniciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vLogin, vClave;
		vLogin=request.getParameter("login");
		vClave=request.getParameter("clave");
		Usuario bean = sUsuario.iniciarLogin(vLogin, vClave);
		if(bean==null) {
			request.setAttribute("MENSAJE","Usuario y/o clave incorrectos");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			
			HttpSession session=request.getSession();
			
			List<Menu> lista=sUsuario.obtenerMenus(bean.getCodigo());
			session.setAttribute("MENUS", lista);
			session.setAttribute("DATOS", bean.getApellidos()+" "+bean.getNombres());
			request.getRequestDispatcher("/menu.jsp").forward(request, response);
		}
		
	}

}
