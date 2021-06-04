package net.recurso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.recurso.entidad.Solicitud;
import net.recurso.interfaces.SolicitudDAO;
import net.recurso.utils.MySqlConexion;

public class MySqlSolicitudDAO implements SolicitudDAO {

	@Override
	public int registrar(Solicitud bean) {
		int salida = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		//Try Catch/
		
		try {
			//1-Traer la conexion
			cn = MySqlConexion.getConexion();
			//2- Crear una variable con la Sentencia SQL
			String sql = "insert into tb_solicitud values (null,?,?,?,?,?,?)";
			//3-Pasar la sentencia
			pstm = cn.prepareStatement(sql);
			//4-Parametros
			pstm.setInt(1, bean.getCod_user());
			pstm.setInt(2, bean.getCod_area());
			pstm.setInt(3, bean.getCod_informe());
			pstm.setString(4,bean.getFec_info());
			pstm.setString(5,bean.getPerfil_soli());
			pstm.setString(6,bean.getDescri_soli());
			salida = pstm.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(cn!=null)
					cn.close();
				if(pstm!=null)
					pstm.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
		
	}

	@Override
	public int actualizar(Solicitud bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="delete from tb_solicitud where cod_soli=?"; 
			//3
			pstm=cn.prepareStatement(sql);
			//4 
			pstm.setInt(1, cod);
			//5
			salida=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}		
		return salida;
	}

	@Override
	public List<Solicitud> listarSolicitud() {
				List<Solicitud> lista=new ArrayList<Solicitud>();
				Connection cn=null;
				PreparedStatement pstm=null;
				ResultSet rs=null;
				try {
					//1
					cn=MySqlConexion.getConexion();
					//2
					String sql="select *from tb_solicitud"; 
					//3
					pstm=cn.prepareStatement(sql);
					//4 (NO HAYYYYYY)
					
					//5
					rs=pstm.executeQuery();
					//6 while
					while(rs.next()) {
						//7 crear objeto de la clase Docente
						Solicitud bean=new Solicitud();
						//8
						bean.setCod_soli(rs.getInt(1));
						bean.setCod_user(rs.getInt(2));
						bean.setCod_area(rs.getInt(3));
						bean.setCod_informe(rs.getInt(4));
						bean.setFec_info(rs.getString(5));
						bean.setPerfil_soli(rs.getString(6));
						bean.setDescri_soli(rs.getString(7));
						//9
						lista.add(bean);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					try {
						if(rs!=null) rs.close();
						if(pstm!=null) pstm.close();
						if(cn!=null) cn.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				return lista;
	}
	


}
