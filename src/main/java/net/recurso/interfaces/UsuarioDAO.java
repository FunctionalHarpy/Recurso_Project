package net.recurso.interfaces;

import java.util.List;

import net.recurso.entidad.Menu;
import net.recurso.entidad.Usuario;

public interface UsuarioDAO {

	public Usuario iniciarSesion(String vLogin,String vClave);
	public List<Menu> traerMenus(int codUsuario);
}
