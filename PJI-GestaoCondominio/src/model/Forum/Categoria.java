package model.Forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Condominio.ForumGS;
import model.DAO.ConexaoBD;

public class Categoria {
	public static List<ForumGS> getCategoria(){
		String sql = "SELECT * FROM Categoria";
		
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
