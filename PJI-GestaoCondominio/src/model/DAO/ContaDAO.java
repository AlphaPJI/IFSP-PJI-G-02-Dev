package model.DAO;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;
import model.DAO.ConexaoBD;

public class ContaDAO {
	public void read() {
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		query = "SELECT * FROM Conta";
		try {
		ps = c.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
		System.out.println(rs.getString("nome") + " - " + rs.getString("email"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		// Conexao.fecharConexao(c, ps, rs);
		}
		}
}
