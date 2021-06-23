package net.recurso.fabrica;

import net.recurso.dao.MySqlEstadoDAO;
import net.recurso.dao.MySqlSolicitudDAO;
import net.recurso.dao.MySqlUsuarioDAO;
import net.recurso.interfaces.EstadoDAO;
import net.recurso.interfaces.SolicitudDAO;
import net.recurso.interfaces.UsuarioDAO;


public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public SolicitudDAO getSolicitudDAO() {
		// TODO Auto-generated method stub
		return new MySqlSolicitudDAO();
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEstadoDAO();
	}

}
