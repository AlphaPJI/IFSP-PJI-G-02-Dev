package model.Forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Condominio.ForumGS;
import model.DAO.ConexaoBD;

public class Comentarios {
	
	public void comentariosDia(Object codCategoria) {
		
	}
	
	public static List<ForumGS> getComentariosUltimaSemana(int codCategoria){
		String sql = "SELECT * FROM Comentario WHERE id_categoria = '" +codCategoria+ "' AND data_publicacao BETWEEN date_sub(current_date(), INTERVAL 7 DAY) AND current_date()";;
		
		List<ForumGS> comentariosUltimaSemana = new ArrayList<ForumGS>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; 
		
		try {
			conn = ConexaoBD.getConexao();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				ForumGS comentario = new ForumGS();
				
				comentario.setTituloComentarios(rset.getString("titulo"));				
				comentario.setTopico(rset.getString("topico"));
				comentario.setAssunto(rset.getString("assunto"));
				comentario.setDataPublicacao(rset.getDate("data_publicacao"));
				comentario.setIdConta(rset.getInt("id_conta"));
				
				comentariosUltimaSemana.add(comentario);
				

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
		
		return comentariosUltimaSemana;
	}

	public static List<ForumGS> getComentariosMes(int codCategoria){
		System.out.println("get comentarios ultimo mes");
		String sql = "SELECT * FROM Comentario WHERE id_categoria = '" +codCategoria+ "' AND data_publicacao BETWEEN date_sub(current_date(), INTERVAL 1 MONTH) AND current_date()";;
		
		List<ForumGS> comentariosUltimoMes = new ArrayList<ForumGS>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; 
		
		try {
			conn = ConexaoBD.getConexao();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				ForumGS comentario = new ForumGS();
				
				comentario.setTituloComentarios(rset.getString("titulo"));				
				comentario.setTopico(rset.getString("topico"));
				comentario.setAssunto(rset.getString("assunto"));
				comentario.setDataPublicacao(rset.getDate("data_publicacao"));
				comentario.setIdConta(rset.getInt("id_conta"));
				
				comentariosUltimoMes.add(comentario);
				

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
		System.out.println("get comentarios ultimo mes ok");
		return comentariosUltimoMes;
	}
	
	
		public static List<ForumGS> getTodosComentarios(int codCategoria){
			String sql = "SELECT * FROM Comentario WHERE id_categoria = '" + codCategoria + "' ORDER BY data_publicacao desc";;
			
			List<ForumGS> todosComentarios = new ArrayList<ForumGS>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null; 
			
			try {
				conn = ConexaoBD.getConexao();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					ForumGS comentario = new ForumGS();
					
					comentario.setTituloComentarios(rset.getString("titulo"));				
					comentario.setTopico(rset.getString("topico"));
					comentario.setAssunto(rset.getString("assunto"));
					comentario.setDataPublicacao(rset.getDate("data_publicacao"));
					comentario.setIdConta(rset.getInt("id_conta"));
					
					todosComentarios.add(comentario);
					

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
			
			return todosComentarios;
		}
		
		
		
		public static List<ForumGS> nomeBloco(int[] idConta){
			System.out.println("nome bloco");
			List<ForumGS> nomeBloco = new ArrayList<ForumGS>();
			
			String sql = "SELECT * FROM Conta";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			int x=0;
			try {
				conn = ConexaoBD.getConexao();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					ForumGS comentario = new ForumGS();
					
					int id = rset.getInt("id");
					
					if(idConta[x]==id) {
						comentario.setNome(rset.getString("nome"));
						comentario.setBloco(rset.getString("bloco"));
						nomeBloco.add(comentario);
						x++;
					}
					if(x>=idConta.length) {
						break;
					}

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
			System.out.println("nome bloco ok");
			return nomeBloco;
		}

	
}

