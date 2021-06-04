package net.recurso.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.recurso.utils.MySqlConexion;
import net.recurso.entidad.Menu;
import net.recurso.entidad.Usuario;
import net.recurso.interfaces.UsuarioDAO;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario iniciarSesion(String vLogin, String vClave) {
		Usuario bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select cod_user,nom_user,ape_user from tb_user where log_user=? and pass_user=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, vLogin);
			pstm.setString(2, vClave);
			rs=pstm.executeQuery();
			//validar si rs contine fila
			if(rs.next()) {//si tiene fila
				bean=new Usuario();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
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
		return bean;
	}

	@Override
	public List<Menu> traerMenus(int codUsuario) {
		List<Menu> lista=new ArrayList<Menu>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlConexion.getConexion();
			String sql="select a.cod_menu,m.desc_menu,m.url_menu "
					+ "from tb_acceso a join tb_menu m "
					+ "on a.cod_menu=m.cod_menu where a.cod_user=?"; 
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codUsuario);
			rs=pstm.executeQuery();
			while(rs.next()) {
				Menu bean=new Menu();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setUrl(rs.getString(3));
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

	@Override
	public List<Usuario> listAll() {
		//declarar y crear lista de Docentes
				List<Usuario> lista=new ArrayList<Usuario>();
				Connection cn=null;
				PreparedStatement pstm=null;
				ResultSet rs=null;
				try {
					//1
					cn=MySqlConexion.getConexion();
					//2
					String sql="select cod_user, nom_user, ape_user, fdn_user, correo_user, dir_user,"
							+ "estado_user from tb_user"; 
					//3
					pstm=cn.prepareStatement(sql);
					//4 (NO HAYYYYYY)
					
					//5
					rs=pstm.executeQuery();
					//6 while
					while(rs.next()) {
						//7 crear objeto de la clase Usuario
						Usuario bean=new Usuario();
						//8
						bean.setCodigo(rs.getInt(1));
						bean.setNombres(rs.getString(2));
						bean.setApellidos(rs.getString(3));
						bean.setFdn(rs.getString(4));
						bean.setCorreo(rs.getString(5));
						bean.setDire(rs.getString(6));
						bean.setEstado(rs.getInt(7));
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
