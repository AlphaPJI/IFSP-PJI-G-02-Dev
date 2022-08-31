package controller;
import view.Tela;

public class AppGestaoCondominio 
{

	public static void main(String[] args) 
	{
		Tela telaEntrada = new Tela();
		telaEntrada.BoasVindas();
		
		String codUser = telaEntrada.TelaUsuario();
		
		String forum = telaEntrada.Forum();
	}
}
