package view;

import javax.swing.JOptionPane;

import model.Forum.Comentarios;
import model.Forum.Forum;

public class TelaForum {
	
	public void escolhaCategoria() {
		Forum forum = new Forum();
		String[] categorias = forum.Forum();
		
		Object categ = JOptionPane.showInputDialog(null, "Escolha a categoria do forúm", " ", JOptionPane.INFORMATION_MESSAGE, null, categorias, categorias[0]);
		
		String[] codComments = { "Última semana", "Último mês", "Mostrar todos"};
		int escCodComments = JOptionPane.showOptionDialog(null, "Deseja visualizar os comentários:", "Gestão de Condominio",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		null, codComments, codComments[0]);
		
		if(escCodComments==0) {
			Comentarios comentarios = new Comentarios();
			comentarios.comentariosSemana(categ);
		}else if(escCodComments==1) {
			Comentarios comentarios = new Comentarios();
			comentarios.comentariosMes(categ);
		}else if(escCodComments==2) {
			Comentarios comentarios = new Comentarios();
			String todosComentarios = comentarios.todosComentarios(categ);

		}	
			}

}


