package controller;
import view.Tela;
import model.Condominio.Conta;
import model.DAO.ConexaoBD;
import model.DAO.ContaD;
import model.DAO.ContaDAO;

public class AppGestaoCondominio 
{

	public static void main(String[] args) 
	{
		ContaDAO conta = new ContaDAO();
		conta.read();
		
		ContaD contaDao = new ContaD();
		Conta contaD = new Conta();
		contaD.setId(99);
		contaD.setNome("Cain");
		contaD.setEmail("cain@gmail.com");
		contaD.setSenha("Maria");
		contaD.setCpf("1234567");
		contaD.setRg("76541X");
		contaD.setVerificarEmail(true);
		contaD.setVerificado(true);
		contaD.setAdministrador(false);
		contaD.setApartamento("78");
		contaD.setBloco("Bloco B");
		contaDao.save(contaD);
		
		Tela tela = new Tela();
		tela.BoasVindas();
		tela.TelaUsuario();	
		tela.Forum();
		
	}
}
