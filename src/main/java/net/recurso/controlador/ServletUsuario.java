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
		else if(tipo.equals("CERRAR"))
			cerrar(request,response);
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
