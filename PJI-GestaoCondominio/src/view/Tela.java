package view;
import javax.swing.JOptionPane;

import model.DAO.DBuser;

public class Tela 
{
	public void BoasVindas()
	{
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de Gestão de Condominio!");
	}
	
	public String TelaUsuario ()
	{
		String codUsuario = JOptionPane.showInputDialog(null, "Por favor, insira o seu usuário: ");
		JOptionPane.showMessageDialog(null, "Bem vindo(a) " +codUsuario);
		return codUsuario;
	}
	
	public String Forum ()
	{
		String forum = JOptionPane.showInputDialog("Selecione o Forúm:\n1- Lazer \n2- Sugestões \n3- Reclamações \n4- Festividades \n5- Ideias \n6- Avisos \n7- Conversas \n8- Debates \n9- Reuniões \n10- Outros");
		DBuser.acessaForum(forum);
		return forum;
	}
}
