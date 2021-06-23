package net.recurso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import net.recurso.entidad.Estado;
import net.recurso.interfaces.EstadoDAO;
import net.recurso.utils.MySqlConexion;

public class MySqlEstadoDAO implements EstadoDAO {

	@Override
	public List<Estado> listAll() {
		List<Estado> lista=new ArrayList<Estado>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=MySqlConexion.getConexion();
			//2
			String sql="select *from tb_estado"; 
			//3
			pstm=cn.prepareStatement(sql);
			//4 (NO HAYYYYYY)
			
			//5
			rs=pstm.executeQuery();
			//6 while
			while(rs.next()) {
				//7 crear objeto de la clase Docente
				Estado bean=new Estado();
				//8
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
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
