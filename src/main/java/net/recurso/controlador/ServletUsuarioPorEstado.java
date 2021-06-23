package net.recurso.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.recurso.entidad.Usuario;
import net.recurso.services.UsuarioService;

@MultipartConfig
@WebServlet("/ServletUsuarioPorEstado")
public class ServletUsuarioPorEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletUsuarioPorEstado() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String estado;
		estado=request.getParameter("estado");
		System.out.println(estado);
		List<Usuario> lista = new UsuarioService().listarTodosUsuariosPorEstado(Integer.parseInt(estado));
		Gson gson=new Gson();
		String json=gson.toJson(lista);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter salida=response.getWriter();
		//salida.write(json);
		salida.println(json);
		
	}

}
