package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JOptionPane;

import model.Condominio.Conta;
import view.Tela;

public class Cadastro {
	public static void LoginOuCadastro(String codLoginCadastro){
		String login = "L";
		String registro = "C";
		if(codLoginCadastro.equalsIgnoreCase(login)) {
			Tela tela = new Tela();
			tela.TelaUsuario();
		}else if(codLoginCadastro.equalsIgnoreCase(registro)) {
			Cadastro cadastro = new Cadastro();
			cadastro.Cadastrar();
		}else
		JOptionPane.showMessageDialog(null, "Opção inválida");
		System.exit(0);
		
	}
	
	public void Cadastrar(){
		
		String nome = JOptionPane.showInputDialog(null, "Nome completo: ");
		String email = JOptionPane.showInputDialog(null, "Email: ");
		String senha = JOptionPane.showInputDialog(null, "Senha: ");
		String cpf = JOptionPane.showInputDialog(null, "Cpf (Sem caracteres especiais): ");
		String rg = JOptionPane.showInputDialog(null, "Rg (Sem caracteres especiais): ");
		String apartamento = JOptionPane.showInputDialog(null, "Apartamento: ");
		String bloco = JOptionPane.showInputDialog(null, "Bloco: ");
		
		Cadastro cadastro = new Cadastro();
		int id = cadastro.id();
		
		System.out.println("-"+id++);
		
		ContaD contaDao = new ContaD();
		Conta contaD = new Conta();
		contaD.setId(id++);
		contaD.setNome(nome);
		contaD.setEmail(email);
		contaD.setSenha(senha);
		contaD.setCpf(cpf);
		contaD.setRg(rg);
		contaD.setVerificarEmail(true);
		contaD.setVerificado(true);
		contaD.setAdministrador(false);
		contaD.setApartamento(apartamento);
		contaD.setBloco(bloco);
		contaDao.save(contaD);
		
	}
	
	
	public int id() {
		ConexaoBD con = new ConexaoBD();
		Connection c;
		c = con.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		query = "SELECT * FROM Conta";
		
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
