package view;
import javax.swing.JOptionPane;

import model.Condominio.Conta;
import model.DAO.Cadastro;
import model.DAO.ContaD;
import model.DAO.ContaDAO;
import model.DAO.EncriptaDescripta;
import model.Forum.Forum;

public class Tela 
{
	public void boasVindas()
	{
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de Gestão de Condominio!");
	}
	
	public void TelaLoginCadastro(){
		String[] escCodLoginCadastro = { "Login", "Cadastrar" };
		int codLoginCadastro = JOptionPane.showOptionDialog(null, "Deseja fazer Login ou Cadastrar novo usuario?", "Gestão de Condominio",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		null, escCodLoginCadastro, escCodLoginCadastro[0]);		
		System.out.println("--"+codLoginCadastro);
		Cadastro.LoginOuCadastro(codLoginCadastro);
		loginUsuario();
	}
	
	public void escolhaTelaInicio() {
		String[] escCodTelaInicio = { "Forum", "Gestão", "Notícias", "Chamados", "Conta" };
		int codTelaInicio = JOptionPane.showOptionDialog(null, "TELA DE INÍCIO", "Gestão de Condominio",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		null, escCodTelaInicio, escCodTelaInicio[0]);
		if(codTelaInicio==0) {
			TelaForum telaForum = new TelaForum();
			telaForum.escolhaCategoria();
		}else if(codTelaInicio==1) {
			JOptionPane.showMessageDialog(null, "Work in progress...", "Alerta", JOptionPane.ERROR_MESSAGE);
		}else if(codTelaInicio==2) {
			JOptionPane.showMessageDialog(null, "Work in progress....", "Alerta", JOptionPane.ERROR_MESSAGE);
		}else if(codTelaInicio==3) {
			JOptionPane.showMessageDialog(null, "Work in progress.....", "Alerta", JOptionPane.ERROR_MESSAGE);
		}else if(codTelaInicio==4) {
			JOptionPane.showMessageDialog(null, "Work in progress......", "Alerta", JOptionPane.ERROR_MESSAGE);
		}
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
		
		JOptionPane.showMessageDialog(null, "Bem vindo(a) "+conta.getNome()+"\nVocê foi autenticado com sucesso!");
		escolhaTelaInicio();
	}
	
	public String obtemEmail() {
		String email;
		int valor_correto_OK = 0;
		int email_correto = 0;
		int cont = 0;
		do {
			if(cont>=3) {
				String[] escEscolhaEmail = { "Sim", "Continuar tentando", "Cancelar"};
				int escolhaEmail = JOptionPane.showOptionDialog(null, "Deseja alterar o email?", "Gestão de Condomio", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
				null, escEscolhaEmail, escEscolhaEmail[0]);
				if(escolhaEmail==0) {
					novoEmail();
				} else if(escolhaEmail==2) {
					System.exit(0);
				}
			
			}
			email = (JOptionPane.showInputDialog(null, "Insira o seu email: "));
			if (!email.equals(null)) {
				email_correto = ContaDAO.Email(email);		
				if (email.equals("")) {					
					JOptionPane.showMessageDialog(null, "Você não informou seu email", "Alerta", JOptionPane.ERROR_MESSAGE);
				} 
				if(email_correto==1){
					valor_correto_OK = 1;
				} else {
					JOptionPane.showMessageDialog(null, "Email incorreto", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
			cont++;
		} while (valor_correto_OK==0);
		return email;
		
	}
	
	public String obtemSenha() {
		String senha;
		int valor_correto_OK = 0;
		int cont = 0;
		int senha_correta = 0;
		do {			
			if(cont>=3) {
				String[] escEscolhaSenha = { "Sim", "Continuar tentando", "Cancelar"};
				int escolhaSenha = JOptionPane.showOptionDialog(null, "Deseja alterar a senha?", "Gestão de Condomio", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, escEscolhaSenha, escEscolhaSenha[0]);
				if(escolhaSenha==0) {
					novaSenha();
				} else if(escolhaSenha==2) {
					System.exit(0);
				}
			}
			senha = (JOptionPane.showInputDialog(null, "Insira a sua senha: "));
			if (!senha.equals(null)) {
				String senhaCriptografada = EncriptaDescripta.Criptografia(senha);
				senha_correta = ContaDAO.Senha(senhaCriptografada);
				if (senha.equals("")) {					
					JOptionPane.showMessageDialog(null, "Você não informou sua senha", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
				if(senha_correta==1){
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Senha incorreta", "Alerta", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Você não informou seu email", "Alerta", JOptionPane.ERROR_MESSAGE);
				} 
				if(email_correto==1){
					conta.setEmail(email);
					valor_correto_OK = 1;
				} else {
					JOptionPane.showMessageDialog(null, "Email inválido", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (valor_correto_OK==0);
		String novaSenha = JOptionPane.showInputDialog(null, "Insira a sua senha nova: ");
		String senhaCriptografada = EncriptaDescripta.Criptografia(novaSenha);
		conta.setNovaSenha(senhaCriptografada);				
		contaD.updateSenha(conta);
		
		JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
	}
	
	public void novoEmail() {
		String emailRecuperacao;
		int valor_correto_OK = 0;
		int email_correto = 0;
		ContaD contaD = new ContaD();
		Conta conta = new Conta();
		do {
			emailRecuperacao = (JOptionPane.showInputDialog(null, "Insira o seu email de recuperacao: "));
			if (!emailRecuperacao.equals(null)) {
				email_correto = ContaDAO.EmailRecuperacao(emailRecuperacao);		
				if (emailRecuperacao.equals("")) {					
					JOptionPane.showMessageDialog(null, "Você não informou seu email de recuperacao", "Alerta", JOptionPane.ERROR_MESSAGE);
				} 
				if(email_correto==1){
					conta.setEmailRecuperacao(emailRecuperacao);
					valor_correto_OK = 1;
				} else {
					JOptionPane.showMessageDialog(null, "Email inválido", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (valor_correto_OK==0);
		String novoEmail= JOptionPane.showInputDialog(null, "Insira seu novo email : ");
		conta.setNovoEmail(novoEmail);
		contaD.updateEmail(conta);
		
		JOptionPane.showMessageDialog(null, "Email alterado com sucesso");
	}
	


}
