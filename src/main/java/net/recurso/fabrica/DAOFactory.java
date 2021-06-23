package net.recurso.fabrica;

import net.recurso.fabrica.DAOFactory;
import net.recurso.fabrica.MySqlDAOFactory;
import net.recurso.interfaces.EstadoDAO;
import net.recurso.interfaces.SolicitudDAO;
import net.recurso.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	 public static final int MYSQL = 1;
	 public static final int ORACLE = 2;
	 public static final int DB2 = 3;
	 public static final int SQLSERVER = 4;
	 public static final int XML = 5;
	 
	 public abstract UsuarioDAO getUsuarioDAO(); 
	 public abstract SolicitudDAO getSolicitudDAO(); 
	 public abstract EstadoDAO getEstadoDAO();
	 
	 public static DAOFactory getDAOFactory(int whichFactory){
	        switch(whichFactory){
	       	case MYSQL:
	        	   return new MySqlDAOFactory();
	        	case XML:
	        	    //return new XmlDAOFactory();
	        	case ORACLE:
	        	    return null;
	        	/*case DB2:
	        	    return new Db2DAOFactory();*/
	        	case SQLSERVER:
	        	    return null;
	        	/*case XML:
	        	    return new XmlDAOFactory();*/
	        	default:
	        	    return null;
	        }
	     }

}
