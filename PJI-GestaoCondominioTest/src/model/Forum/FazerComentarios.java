package model.Forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Condominio.Conta;
import model.Condominio.ForumGS;
import model.DAO.Cadastro;
import model.DAO.ConexaoBD;
import model.DAO.ContaD;
import model.DAO.EncriptaDescripta;
import java.util.Date;

public class FazerComentarios {
	public void save(ForumGS forum, boolean avaliação) {
		String sql = "INSERT INTO Comentario(id, id_conta, id_categoria, titulo, topico, assunto, avaliação, data_publicacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = null;
			PreparedStatement pstm = null;
			
				try { 
					conn = ConexaoBD.getConexao();
					pstm = conn.prepareStatement(sql);
						pstm.setInt(1, forum.getIdComentario());
						pstm.setString(2, forum.getTituloComentarios());
						pstm.setString(3, forum.getTopico());
						pstm.setString(4, forum.getAssunto());
						pstm.setDate(5, (java.sql.Date) new Date(forum.getDataPublicacao().getTime()));
						pstm.setString(6, forum.getNome());
						pstm.setString(7, forum.getBloco());
						
						
					pstm.execute();
					System.out.println("Cadastro OK");
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(pstm!=null) {
							pstm.close();
						}
						if(conn!=null) {
							conn.close();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
	}
	
	public void CadastrarComentarios(){
		
		String titulo = JOptionPane.showInputDialog(null, "Titulo do comentário: ");
		String topico = JOptionPane.showInputDialog(null, "Tópico da discussão: ");
		String assunto = JOptionPane.showInputDialog(null, "Assunto: ");
		
		FazerComentarios idComentarios = new FazerComentarios();
		int id = idComentarios.id();
		
		System.out.println("-"+id++);
		
		FazerComentarios fazerComentarios = new FazerComentarios();
		ForumGS forumGS = new ForumGS();
		Date data = new Date();
		
		forumGS.setIdComentario(3);
		forumGS.setIdConta(28);
		forumGS.setId(3);
		forumGS.setTituloComentarios("Aulas de programação");
		forumGS.setTopico("Aula");
		forumGS.setAssunto("Estou oferecendo aulas de programação");
		forumGS.setAvaliacao(true);
		forumGS.setDataPublicacao((java.sql.Date) new Date());
		
		System.out.println("Comentario realizado");
		
		
	}
	
	public int id() {
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		query = "SELECT * FROM Comentario";
		
		int id = 0;
		
		try {
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				System.out.println("- " + id);
			}
			return id;
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return id;
	}

}

