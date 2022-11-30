package view;

import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Condominio.ForumGS;
import model.Forum.VerComentarios;
import model.Forum.Forum;

public class TelaForum {
	
	public void escolhaCategoria() {
		Forum forum = new Forum();
		String[] categorias = forum.Forum();
		Object escCategoria = JOptionPane.showInputDialog(null, "Escolha a categoria do forúm", " ", JOptionPane.INFORMATION_MESSAGE, null, categorias, categorias[0]);
		
		int codCategoria = 0;
		for(int cont=0 ; cont<=categorias.length; cont++) {
			if(escCategoria==categorias[cont]) {
				codCategoria = cont+1;
				break;
			}
		}
		
		String[] codComments = { "Última semana", "Último mês", "Mostrar todos"};
		int escCodComments = JOptionPane.showOptionDialog(null, "Deseja visualizar os comentários:", "Gestão de Condominio",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		null, codComments, codComments[0]);
		
		if(escCodComments==0) {
			forum.comentariosUltimaSemana(codCategoria);
		}else if(escCodComments==1) {
			forum.comentariosUltimoMes(codCategoria);
		}else if(escCodComments==2) {
			forum.todosComentarios(codCategoria);
		}	
			}
	
	
	public void exibirTodosComentarios(String[] assuntoComentarios, String[] tituloComentarios, String[] topicoComentarios, Date[] dataPublicacaoComentarios, int[] idConta, int x, String[] nome, String[] bloco) {
		System.out.println("todos comentarios");
		
		for(int cont=0; cont<x; cont++) {
		System.out.println("\n\nTopico: " +topicoComentarios[cont]+ "\nTitulo: " +tituloComentarios[cont]+ "\nAssunto: " +assuntoComentarios[cont]+ "\nData de publicação: " +dataPublicacaoComentarios[cont]+ "\nFeito por: " +nome[cont]+ "\nBloco: " +bloco[cont]);
		JOptionPane.showMessageDialog(null, "\n\nTopico: " +topicoComentarios[cont]+ "\nTitulo: " +tituloComentarios[cont]+ "\nAssunto: " +assuntoComentarios[cont]+ "\nData de publicação: " +dataPublicacaoComentarios[cont]+ "\nFeito por: " +nome[cont]+ "\nBloco: " +bloco[cont]);
		}
		System.out.println("todos comentarios ok");
	}
	
	
	public void exibirComentariosUltimoMes(String[] assuntoComentarios, String[] tituloComentarios, String[] topicoComentarios, Date[] dataPublicacaoComentarios, int[] idConta, int x, String[] nome, String[] bloco) {
		System.out.println("comentarios ultimo mes");
		
		for(int cont=0; cont<x; cont++) {
		System.out.println("\n\nTopico: " +topicoComentarios[cont]+ "\nTitulo: " +tituloComentarios[cont]+ "\nAssunto: " +assuntoComentarios[cont]+ "\nData de publicação: " +dataPublicacaoComentarios[cont]+ "\nFeito por: " +nome[cont]+ "\nBloco: " +bloco[cont]);
		JOptionPane.showMessageDialog(null, "\n\nTopico: " +topicoComentarios[cont]+ "\nTitulo: " +tituloComentarios[cont]+ "\nAssunto: " +assuntoComentarios[cont]+ "\nData de publicação: " +dataPublicacaoComentarios[cont]+ "\nFeito por: " +nome[cont]+ "\nBloco: " +bloco[cont]);
		}
		System.out.println("comentarios ultimo mes ok");
	}
	
	public void exibirComentariosUltimaSemana(String[] assuntoComentarios, String[] tituloComentarios, String[] topicoComentarios, Date[] dataPublicacaoComentarios, int[] idConta, int x, String[] nome, String[] bloco) {
		System.out.println("comentarios ultima semana");
		
		for(int cont=0; cont<x; cont++) {
		System.out.println("\n\nTopico: " +topicoComentarios[cont]+ "\nTitulo: " +tituloComentarios[cont]+ "\nAssunto: " +assuntoComentarios[cont]+ "\nData de publicação: " +dataPublicacaoComentarios[cont]+ "\nFeito por: " +nome[cont]+ "\nBloco: " +bloco[cont]);
		JOptionPane.showMessageDialog(null, "\n\nTopico: " +topicoComentarios[cont]+ "\nTitulo: " +tituloComentarios[cont]+ "\nAssunto: " +assuntoComentarios[cont]+ "\nData de publicação: " +dataPublicacaoComentarios[cont]+ "\nFeito por: " +nome[cont]+ "\nBloco: " +bloco[cont]);
		}
		System.out.println("comentarios ultima semana ok");
	}
	

}


