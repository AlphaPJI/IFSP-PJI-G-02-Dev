package view;
import javax.swing.JOptionPane;

import model.Condominio.Conta;
import model.DAO.Cadastro;
import model.DAO.ContaD;
import model.DAO.ContaDAO;
import model.DAO.DBuser;

public class Tela 
{
	public Tela()
	{
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de Gestão de Condominio!");
	}
	
	public void TelaLoginCadastro(){
		String codLoginCadastro = JOptionPane.showInputDialog(null, "Deseja fazer Login ou Cadastrar novo usuario\n[L] para Login\n[C] para Cadastrar-se");
		Cadastro.LoginOuCadastro(codLoginCadastro);
		loginUsuario();
	}
	
	public void loginUsuario ()
	{		
		Conta conta = new Conta();		

		String email = obtemEmail();
		String senha = obtemSenha();
		
		conta.setEmail(email);
		conta.setSenha(senha);	
		
		String usuario = ContaDAO.Usuario(conta.getEmail());
		conta.setNome(usuario);
		
		JOptionPane.showMessageDialog(null, "Bem vindo(a) " +conta.getNome());
	}
	
	public String obtemEmail() {
		String email;
		int valor_correto_OK = 0;
		int email_correto = 0;
		do {
			email = (JOptionPane.showInputDialog(null, "Insira o seu email: "));
			if (!email.equals(null)) {
				email_correto = ContaDAO.Email(email);		
				if (email.equals("")) {					
					JOptionPane.showMessageDialog(null, "Voce nao inseriu seu email");
				} 
				if(email_correto==1){
					valor_correto_OK = 1;
				} else {
					JOptionPane.showMessageDialog(null, "Email incorreto");
				}
			}
		} while (valor_correto_OK==0);
		return email;
		
	}
	
	public String obtemSenha() {
		String senha;
		String alterarSenha = "S";
		int valor_correto_OK = 0;
		int cont = 0;
		int senha_correta = 0;
		do {			
			if(cont>=3) {
				String escolhaSenha = JOptionPane.showInputDialog(null, "Deseja alterar a senha?\n[S] Sim\n[N] Não");
				if(escolhaSenha.equalsIgnoreCase(alterarSenha)) {
					novaSenha();
				}
			}
			senha = (JOptionPane.showInputDialog(null, "Insira a sua senha: "));
			if (!senha.equals(null)) {
				senha_correta = ContaDAO.Senha(senha);
				if (senha.equals("")) {					
					JOptionPane.showMessageDialog(null, "Voce nao informou sua senha");
				}
				if(senha_correta==1){
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Senha incorreta");
				}
			}
			cont++;
		} while (valor_correto_OK==0);
		return senha;
		
	}
	
	public void novaSenha() {
		String email;
		int valor_correto_OK = 0;
		int email_correto = 0;
		ContaD contaD = new ContaD();
		Conta conta = new Conta();
		do {
			email = (JOptionPane.showInputDialog(null, "Insira o seu email: "));
			if (!email.equals(null)) {
				email_correto = ContaDAO.Email(email);		
				if (email.equals("")) {					
					JOptionPane.showMessageDialog(null, "Voce nao inseriu seu email");
				} 
				if(email_correto==1){
					conta.setEmail(email);
					valor_correto_OK = 1;
				} else {
					JOptionPane.showMessageDialog(null, "Email invalido");
				}
			}
		} while (valor_correto_OK==0);
		String novaSenha = JOptionPane.showInputDialog(null, "Insira a sua senha nova: ");
		conta.setNovaSenha(novaSenha);				
		contaD.update(conta);
		
		JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
	}
	

}
