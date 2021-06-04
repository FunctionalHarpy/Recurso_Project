package net.recurso.interfaces;

import java.util.List;
import net.recurso.entidad.Solicitud;


public interface SolicitudDAO {
	public int registrar(Solicitud bean);
	public int actualizar(Solicitud bean);
	public int eliminar(int cod);
	public List<Solicitud> listarSolicitud();
}
