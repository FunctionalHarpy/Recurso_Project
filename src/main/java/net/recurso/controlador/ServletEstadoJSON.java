package net.recurso.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.recurso.entidad.Estado;
import net.recurso.services.EstadoService;




@WebServlet("/ServletEstadoJSON")
public class ServletEstadoJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletEstadoJSON() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Estado> lista=new EstadoService().listarTodos();
		//crear objeto de la clase Gson
		Gson gson=new Gson();
		//convertir a JSON el valor que almacena lista
		String json;
		json=gson.toJson(lista);
		//establecer formato de salida tipo "JSON"
		response.setContentType("application/json;charset=UTF-8");
		//proceso de imprimir
		PrintWriter salida=response.getWriter();
		salida.println(json);	
	}

}
