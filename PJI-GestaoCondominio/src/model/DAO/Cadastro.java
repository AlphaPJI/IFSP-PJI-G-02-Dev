package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import model.Condominio.Conta;
import view.Tela;

public class Cadastro {
	public static void LoginOuCadastro(int codLoginCadastro){
		Cadastro cadastro = new Cadastro();
		ContaDAO contaDAO = new ContaDAO();
		Conta conta = new Conta();
		ContaD contaD = new ContaD();
		int email_correto = 0;
		int valor_correto_OK = 0;
		if(codLoginCadastro==0) {
			Tela tela = new Tela();
			tela.loginUsuario();
		}else if(codLoginCadastro==1) {
			String[] escCodMoradorSindico = { "Morador", "Sindico"};
			int codMoradorSindico = JOptionPane.showOptionDialog(null, "Deseja cadastrar-se como Morador ou Sindico?", "Gestão de Condomio", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			null, escCodMoradorSindico, escCodMoradorSindico[0]);
			if(codMoradorSindico==0) {				
				cadastro.CadastrarMorador();
			}else if(codMoradorSindico==1) {
				do {
				String emailVerificacao = JOptionPane.showInputDialog(null, "Insira seu email para verificação: ");
				email_correto = ContaDAO.Email(emailVerificacao);
				if(!emailVerificacao.equals(null)) {
					if(emailVerificacao.equals("")) {
						JOptionPane.showMessageDialog(null, "Você não informou seu email", "Alerta", JOptionPane.ERROR_MESSAGE);
					}else {
					if(email_correto==1){
						valor_correto_OK = 1;
						conta.setEmail(emailVerificacao);
						contaD.updateAdmin(conta);
						JOptionPane.showMessageDialog(null, "Conta atualizada");
					} else {
						valor_correto_OK = 1;
						cadastro.CadastrarSindico();
					}
					}
				}
				}while(valor_correto_OK==0);				
				
				
			}else
				JOptionPane.showMessageDialog(null, "Tela fechada", "Alerta", JOptionPane.ERROR_MESSAGE);
		}else
		JOptionPane.showMessageDialog(null, "Tela fechada", "Alerta", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
		
	}
	
	public void CadastrarMorador(){
		
		String nome = JOptionPane.showInputDialog(null, "Nome completo: ");
		String email = JOptionPane.showInputDialog(null, "Email: ");
		String senha = JOptionPane.showInputDialog(null, "Senha: ");
		String cpf = JOptionPane.showInputDialog(null, "Cpf (Sem caracteres especiais): ");
		String rg = JOptionPane.showInputDialog(null, "Rg (Sem caracteres especiais): ");
		String apartamento = JOptionPane.showInputDialog(null, "Apartamento: ");
		String[] escBloco = {"Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"};
		Object bloco = JOptionPane.showInputDialog(null, "Escolha seu bloco: ", " ", JOptionPane.INFORMATION_MESSAGE, null, escBloco, escBloco[0]);
		String emailRecuperacao = JOptionPane.showInputDialog(null, "Email para recuperação: ");
		
		String senhaCriptografada = EncriptaDescripta.Criptografia(senha);
		
		Cadastro cadastro = new Cadastro();
		int id = cadastro.id();
		
		System.out.println("-"+id++);
		
		ContaD contaDao = new ContaD();
		Conta contaD = new Conta();
		
		contaD.setId(id++);
		contaD.setNome(nome);
		contaD.setEmail(email);
		contaD.setSenhaCriptografada(senhaCriptografada);
		contaD.setCpf(cpf);
		contaD.setRg(rg);
		contaD.setVerificarEmail(true);
		contaD.setVerificado(true);
		contaD.setEmailRecuperacao(emailRecuperacao);
		contaD.setAdministrador(false);
		contaD.setApartamento(apartamento);
		contaD.setBloco(bloco);
		contaDao.save(contaD, contaD.isVerificarEmail(), contaD.isVerificado(), contaD.isAdministrador());
		
		System.out.println("Cadastro realizado");
		
		
	}
	public void CadastrarSindico(){
		
		JOptionPane.showMessageDialog(null, "Cadastre sua conta");
		
		String nome = JOptionPane.showInputDialog(null, "Nome completo: ");
		String email = JOptionPane.showInputDialog(null, "Email: ");
		String senha = JOptionPane.showInputDialog(null, "Senha: ");
		String cpf = JOptionPane.showInputDialog(null, "Cpf (Sem caracteres especiais): ");
		String rg = JOptionPane.showInputDialog(null, "Rg (Sem caracteres especiais): ");
		String apartamento = JOptionPane.showInputDialog(null, "Apartamento: ");
		String[] escBloco = {"Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"};
		Object bloco = JOptionPane.showInputDialog(null, "Escolha seu bloco: ", " ", JOptionPane.INFORMATION_MESSAGE, null, escBloco, escBloco[0]);
		String emailRecuperacao = JOptionPane.showInputDialog(null, "Email para recuperação: ");
		
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
		contaD.setEmailRecuperacao(emailRecuperacao);
		contaD.setAdministrador(true);
		contaD.setApartamento(apartamento);
		contaD.setBloco(bloco);
		contaDao.save(contaD, contaD.isVerificarEmail(), contaD.isVerificado(), contaD.isAdministrador());
		
		System.out.println("Cadastro realizado");
		JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso");
		
		
	}
	
	public void UpdateSindico() {
		
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
