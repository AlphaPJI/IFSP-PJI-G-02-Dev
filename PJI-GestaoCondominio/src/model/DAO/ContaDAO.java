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
	
	public static int Email(String email){
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery = null;
		sqlQuery = "SELECT * FROM conta WHERE email = '" + email + "'";;
		
		String[] emailBD = new String[40];
		
		try {
			ps = c.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				int x=0;
				emailBD[x] = rs.getString("email");
				System.out.println("- " + emailBD[x]);
				if(emailBD[x].equals(email)) {
					return 1;
				}
				x++;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}	
		return 0;
	}
	
	public static int Senha(String senha){
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sqlQuery = null;
		sqlQuery =  "SELECT * FROM conta WHERE senha = '" + senha + "'";
		
		String[] senhaBD = new String[40];
		
		try {
			ps = c.prepareStatement(sqlQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				int x=0;
				senhaBD[x] = rs.getString("senha");
				System.out.println("- " + senhaBD[x]);
				if(senhaBD[x].equalsIgnoreCase(senha)) {
					return 1;
				}
				x++;
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return 0;
	}
	
}
