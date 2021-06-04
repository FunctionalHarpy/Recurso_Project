package net.recurso.services;

import java.util.List;


import net.recurso.entidad.Solicitud;
import net.recurso.fabrica.DAOFactory;
import net.recurso.interfaces.SolicitudDAO;

public class SolicitudService {
	private DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	private SolicitudDAO solicitudDAO=fabrica.getSolicitudDAO();
	
	
	public List<Solicitud> listarTodos(){
		return solicitudDAO.listarSolicitud();
	}
	
	public int agregar(Solicitud bean) {
		return solicitudDAO.registrar(bean);
	}
	
	public int eliminar(int cod) {
		return solicitudDAO.eliminar(cod);
	}
}
