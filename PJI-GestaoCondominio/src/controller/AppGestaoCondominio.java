package controller;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Condominio.Conta;
import model.DAO.Cadastro;
import model.DAO.ContaD;
import view.Tela;

public class AppGestaoCondominio 
{

	public static void main(String[] args) 
	{
		
		Tela tela = new Tela();
		tela.BoasVindas();
		
		tela.TelaLoginCadastro();
		
		tela.Forum();
		
	}
}
