package model.Forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Condominio.ForumGS;
import model.DAO.ConexaoBD;

public class Comentarios {
	
	public void comentariosSemana(Object codCategoria) {
		
	}

	public void comentariosMes(Object codCategoria) {
		
	}

	public String todosComentarios() {
		public static List<ForumGS> getComentario(int codCategoria){
			String sql = "SELECT * FROM conta WHERE id_categoria = ?'" + codCategoria + "'";;
			
			List<ForumGS> categorias = new ArrayList<ForumGS>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null; 
			
			try {
				conn = ConexaoBD.getConexao();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					ForumGS categoria = new ForumGS();
					
					categoria.setId(rset.getInt("id"));				
					categoria.setTituloCategoria(rset.getString("titulo"));
					
					categorias.add(categoria);
					List<ForumGS> todosComentarios;;
					return todosComentarios;

			} 
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				try {
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return categorias;
		}
			}

	}
}