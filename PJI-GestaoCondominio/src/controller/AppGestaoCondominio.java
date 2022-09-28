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
		
		tela.TelaUsuario();
		
		tela.Forum();
		
		ContaD contaDao = new ContaD();
		Conta contaD = new Conta();
		contaD.setId(50);
		contaD.setNome("Beatriz");
		contaD.setEmail("bea@gmail.com");
		contaD.setSenha("Emo");
		contaD.setCpf("123457");
		contaD.setRg("76591Y");
		contaD.setVerificarEmail(true);
		contaD.setVerificado(true);
		contaD.setAdministrador(false);
		contaD.setApartamento("21");
		contaD.setBloco("Bloco A");
		contaDao.save(contaD);

		
	}
}
