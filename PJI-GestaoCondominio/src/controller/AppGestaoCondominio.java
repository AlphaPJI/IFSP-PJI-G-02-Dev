package controller;
import model.Condominio.Conta;
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
