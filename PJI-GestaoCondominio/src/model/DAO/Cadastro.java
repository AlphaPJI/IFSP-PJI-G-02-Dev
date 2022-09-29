package model.DAO;

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
		
		ContaD contaDao = new ContaD();
		Conta contaD = new Conta();
		contaD.setId(99);
		contaD.setNome("Cain");
		contaD.setEmail("cain@gmail.com");
		contaD.setSenha("Maria");
		contaD.setCpf("1234567");
		contaD.setRg("654321X");
		contaD.setVerificarEmail(true);
		contaD.setVerificado(true);
		contaD.setAdministrador(false);
		contaD.setApartamento("89");
		contaD.setBloco("Bloco C");
		contaDao.save(contaD);
		
	}

}
