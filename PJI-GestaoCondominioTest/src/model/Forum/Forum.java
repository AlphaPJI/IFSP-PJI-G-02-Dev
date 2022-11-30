package model.Forum;

import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Condominio.ForumGS;
import view.TelaForum;

public class Forum {

	public String[] Forum() {
		Categoria categoria = new Categoria();
		categoria.getCategoria();
		int x = 0;
		for(ForumGS c : Categoria.getCategoria()) {
			x++;		
		}
		
		String escCategorias[] = new String[x];
		x=0;
		for(ForumGS c : Categoria.getCategoria()) {
			escCategorias[x] = c.getTituloCategoria();
			x++;		
		}		
		
		System.out.println("escolha categoria ok");
		return escCategorias;
	}
	
	
	public void todosComentarios(int codCategoria) {
		VerComentarios comentarios = new VerComentarios();
		comentarios.getTodosComentarios(codCategoria);
		int x = 0;
		for(ForumGS c : VerComentarios.getTodosComentarios(codCategoria)) {
			x++;		
		}
		
		String assuntoComentarios[] = new String[x];
		String tituloComentarios[] = new String[x];
		String topicoComentarios[] = new String[x];
		Date dataPublicacaoComentarios[] = new Date [x];
		int idConta[] = new int[x];

		x=0;
		for(ForumGS c : VerComentarios.getTodosComentarios(codCategoria)) {
			assuntoComentarios[x] = c.getAssunto();
			tituloComentarios[x] = c.getTituloComentarios();
			topicoComentarios[x] = c.getTopico();
			dataPublicacaoComentarios[x] = c.getDataPublicacao();
			idConta[x] = c.getIdConta();
			x++;		
		}
		
		int y = 0;
		for(ForumGS c : VerComentarios.nomeBloco(idConta)) {
			y++;		
		}
		
		String nome[] = new String[y];
		String bloco[] = new String[y];
		
		y=0;
		for(ForumGS c : VerComentarios.nomeBloco(idConta)) {
			nome[y] = c.getNome();
			bloco[y] = c.getBloco();
			y++;
		}		
		
		TelaForum telaForum = new TelaForum();
		telaForum.exibirTodosComentarios(assuntoComentarios, tituloComentarios, topicoComentarios, dataPublicacaoComentarios, idConta, x, nome, bloco);

	}
	
	public void comentariosUltimoMes(int codCategoria) {
		System.out.println("comentarios ultimo mes forum");
		//Comentarios comentarios = new Comentarios();
		//comentarios.getComentariosMes(codCategoria);
		int x = 0;
		for(ForumGS c : VerComentarios.getComentariosMes(codCategoria)) {
			x++;		
		}
		if(x==0) {
			JOptionPane.showMessageDialog(null, "Não existem comentarios nesse periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		String assuntoComentarios[] = new String[x];
		String tituloComentarios[] = new String[x];
		String topicoComentarios[] = new String[x];
		Date dataPublicacaoComentarios[] = new Date [x];
		int idConta[] = new int[x];

		x=0;
		for(ForumGS c : VerComentarios.getComentariosMes(codCategoria)) {
			assuntoComentarios[x] = c.getAssunto();
			tituloComentarios[x] = c.getTituloComentarios();
			topicoComentarios[x] = c.getTopico();
			dataPublicacaoComentarios[x] = c.getDataPublicacao();
			idConta[x] = c.getIdConta();
			x++;		
		}
		
		System.out.println(idConta[0]);
		int y = 0;
		for(ForumGS c : VerComentarios.nomeBloco(idConta)) {
			y++;		
		}
		System.out.println(y);
		String nome[] = new String[y];
		String bloco[] = new String[y];
		
		y=0;
		for(ForumGS c : VerComentarios.nomeBloco(idConta)) {
			nome[y] = c.getNome();
			bloco[y] = c.getBloco();
			y++;
		}		
		System.out.println("comentarios ultimo mes forum ok");
		TelaForum telaForum = new TelaForum();
		telaForum.exibirComentariosUltimoMes(assuntoComentarios, tituloComentarios, topicoComentarios, dataPublicacaoComentarios, idConta, x, nome, bloco);

	}
	
	public void comentariosUltimaSemana(int codCategoria) {
		
		VerComentarios comentarios = new VerComentarios();
		comentarios.getComentariosUltimaSemana(codCategoria);
		int x = 0;
		for(ForumGS c : VerComentarios.getComentariosUltimaSemana(codCategoria)) {
			x++;		
		}
		if(x==0) {
			JOptionPane.showMessageDialog(null, "Não existem comentarios nesse periodo", "Alerta", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		String assuntoComentarios[] = new String[x];
		String tituloComentarios[] = new String[x];
		String topicoComentarios[] = new String[x];
		Date dataPublicacaoComentarios[] = new Date [x];
		int idConta[] = new int[x];

		x=0;
		for(ForumGS c : VerComentarios.getComentariosUltimaSemana(codCategoria)) {
			assuntoComentarios[x] = c.getAssunto();
			tituloComentarios[x] = c.getTituloComentarios();
			topicoComentarios[x] = c.getTopico();
			dataPublicacaoComentarios[x] = c.getDataPublicacao();
			idConta[x] = c.getIdConta();
			x++;		
		}
		
		int y = 0;
		for(ForumGS c : VerComentarios.nomeBloco(idConta)) {
			y++;		
		}
		
		String nome[] = new String[y];
		String bloco[] = new String[y];
		
		y=0;
		for(ForumGS c : VerComentarios.nomeBloco(idConta)) {
			nome[y] = c.getNome();
			bloco[y] = c.getBloco();
			y++;
		}		
		
		TelaForum telaForum = new TelaForum();
		telaForum.exibirComentariosUltimaSemana(assuntoComentarios, tituloComentarios, topicoComentarios, dataPublicacaoComentarios, idConta, x, nome, bloco);

	}
}
