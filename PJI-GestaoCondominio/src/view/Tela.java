package view;
import javax.swing.JOptionPane;

import model.DAO.Cadastro;
import model.DAO.ContaDAO;
import model.DAO.DBuser;

public class Tela 
{
	public void BoasVindas()
	{
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de Gestão de Condominio!");
	}
	
	public void TelaLoginCadastro(){
		String codLoginCadastro = JOptionPane.showInputDialog(null, "Deseja fazer Login ou Cadastrar novo usuario\n[L] para Login\n[C] para Cadastrar-se");
		Cadastro.LoginOuCadastro(codLoginCadastro);
		Tela tela = new Tela();
		tela.TelaUsuario();
	}
	
	public void TelaUsuario ()
	{		
		String codEmail = JOptionPane.showInputDialog(null, "Insira o seu email: ");
		codEmail = ContaDAO.Email(codEmail);
		String codSenha = JOptionPane.showInputDialog(null, "Insira a sua senha: ");
		codSenha = ContaDAO.Senha(codSenha);
		String codUsuario = ContaDAO.Usuario(codEmail);
		JOptionPane.showMessageDialog(null, "Bem vindo(a) " +codUsuario);
	}
	
	public void Forum ()
	{
		String forum = JOptionPane.showInputDialog("Selecione o Forúm:\n1- Lazer \n2- Sugestões \n3- Reclamações \n4- Festividades \n5- Ideias \n6- Avisos \n7- Conversas \n8- Debates \n9- Reuniões \n10- Outros");
		DBuser.acessaForum(forum);
	}
}
