package controller;
import view.Tela;

public class AppGestaoCondominio 
{

	public static void main(String[] args) 
	{
		Tela telaEntrada = new Tela();
		telaEntrada.BoasVindas();
		
		telaEntrada.TelaUsuario();
		
		telaEntrada.Forum();
	}
}
