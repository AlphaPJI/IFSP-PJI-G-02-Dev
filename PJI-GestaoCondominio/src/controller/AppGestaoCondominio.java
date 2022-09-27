package controller;
import view.Tela;
import model.DAO.ConexaoBD;
import model.DAO.ContaDAO;

public class AppGestaoCondominio 
{

	public static void main(String[] args) 
	{
		ContaDAO conta = new ContaDAO();
		conta.read();
		
		
	}
}
