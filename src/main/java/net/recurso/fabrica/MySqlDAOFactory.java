package net.recurso.fabrica;

import net.recurso.dao.MySqlUsuarioDAO;
import net.recurso.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

}
