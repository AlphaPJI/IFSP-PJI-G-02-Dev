package model.DAO;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import model.DAO.ConexaoBD;

public class ContaDAO {
	
	public static String Usuario(String codEmail){
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		query = "SELECT * FROM Conta";
		
		String[] nome = new String[40];
		String email = codEmail;
		
		try {
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int x=0;
				System.out.println(rs.getString("email"));
				if(email.equals(rs.getString("email"))) {
					nome[x] = rs.getString("nome");
					System.out.println("- " + nome[x]);
					return nome[x];
				}	
				x++;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return null;
	}
	
	public static String Email(String codEmail){
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		query = "SELECT * FROM Conta";
		
		String[] email = new String[40];
		
		try {
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int x=0;
				email[x] = rs.getString("email");
				System.out.println("- " + email[x]);
				if(email[x].equals(codEmail)) {
					return email[x];
				}
				x++;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		JOptionPane.showMessageDialog(null, "Email inválido");
		System.exit(0);
		return null;
	}
	
	public static String Senha(String codSenha){
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		query = "SELECT * FROM Conta";
		
		String[] senha = new String[40];
		
		try {
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int x=0;
				senha[x] = rs.getString("senha");
				System.out.println("- " + senha[x]);
				if(senha[x].equalsIgnoreCase(codSenha)) {
					return senha[x];
				}
				x++;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		JOptionPane.showMessageDialog(null, "Senha incorreta");
		System.exit(0);
		return null;
	}
	
}
