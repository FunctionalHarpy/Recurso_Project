package net.recurso.services;
import java.util.List;

import net.recurso.entidad.Menu;
import net.recurso.entidad.Usuario;
import net.recurso.fabrica.DAOFactory;
import net.recurso.interfaces.UsuarioDAO;
public class UsuarioService {
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private UsuarioDAO usuarioDAO=fabrica.getUsuarioDAO();
	
	public Usuario iniciarLogin(String vLogin,String vClave) {
		return usuarioDAO.iniciarSesion(vLogin, vClave);
	}
	public List<Menu> obtenerMenus(int codUsuario){
		return usuarioDAO.traerMenus(codUsuario);
	}

}
