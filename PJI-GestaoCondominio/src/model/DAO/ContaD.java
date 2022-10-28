package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Condominio.Conta;

public class ContaD {
	public void save(Conta conta, boolean verificar_email, boolean verificado, boolean administrador) {
		String sql = "INSERT INTO Conta(id, nome, email, senha, cpf, rg, verificar_email, verificado, email_recuperacao, administrador, apartamento, bloco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = null;
			PreparedStatement pstm = null;
			
				try { 
					conn = ConexaoBD.getConexao();
					pstm = conn.prepareStatement(sql);
						pstm.setInt(1, conta.getId());
						pstm.setString(2, conta.getNome());
						pstm.setString(3, conta.getEmail());
						pstm.setString(4, conta.getSenha());
						pstm.setString(5, conta.getCpf());
						pstm.setString(6, conta.getRg());
						pstm.setBoolean(7, verificar_email);
						pstm.setBoolean(8, verificado);
						pstm.setString(9, conta.getEmailRecuperacao());
						pstm.setBoolean(10, administrador);
						pstm.setString(11, conta.getApartamento());
						pstm.setObject(12, conta.getBloco());
						
					pstm.execute();
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
	public void updateSenha(Conta conta) {
		String sql = "UPDATE Conta SET senha = ? "+
		"WHERE email = '"+conta.getEmail()+"'";
			Connection conn = null;
			PreparedStatement pstm = null;
			System.out.println("Conexão para alteração de senha funcionando");
		
				try {
					conn = ConexaoBD.getConexao();
					pstm = conn.prepareStatement(sql);
						pstm.setString(1, conta.getNovaSenha());
						pstm.execute();
						
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
	
	public void updateEmail(Conta conta) {
		String sql = "UPDATE Conta SET email = ? "+
		"WHERE email_recuperacao = '"+conta.getEmailRecuperacao()+"'";
			Connection conn = null;
			PreparedStatement pstm = null;
			System.out.println("Conexão para alteração de email funcionando");
		
				try {
					conn = ConexaoBD.getConexao();
					pstm = conn.prepareStatement(sql);
						pstm.setString(1, conta.getNovoEmail());						
						pstm.execute();
						
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
	public void updateAdmin(Conta conta) {
		String sql = "UPDATE Conta SET administrador = true "+
		"WHERE email = '"+conta.getEmail()+"'";
			Connection conn = null;
			PreparedStatement pstm = null;
			System.out.println("Conexão para alteração de sindico funcionando");
		
				try {
					conn = ConexaoBD.getConexao();
					pstm = conn.prepareStatement(sql);						
						pstm.execute();
						
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


}