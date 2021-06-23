package net.recurso.services;

import java.util.List;

import net.recurso.entidad.Estado;
import net.recurso.fabrica.DAOFactory;
import net.recurso.interfaces.EstadoDAO;

public class EstadoService {
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private EstadoDAO estadoDAO=fabrica.getEstadoDAO();
	
	public List<Estado> listarTodos(){
		return estadoDAO.listAll();
	}

}
