package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Condominio.Conta;

public class ContaD {
	public void save(Conta conta) {
		String sql = "INSERT INTO Conta(id, nome, email, senha, cpf, rg, verificar_email, verificado, administrador, apartamento, bloco) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
						pstm.setBoolean(7, false);
						pstm.setBoolean(8, false);
						pstm.setBoolean(9, false);
						pstm.setString(10, conta.getApartamento());
						pstm.setString(11, conta.getBloco());
						
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