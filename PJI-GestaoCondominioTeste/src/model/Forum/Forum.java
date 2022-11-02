package model.Forum;

import java.util.List;

import javax.swing.JOptionPane;

import model.Condominio.ForumGS;

public class Forum {

	public String[] Forum() {
		Categoria categoria = new Categoria();
		categoria.getCategoria();
		String escCategorias[] = new String[10];
		int x = 0;
		for(ForumGS c : Categoria.getCategoria()) {
			escCategorias[x] = c.getTituloCategoria();
			x++;
			
		}
		return escCategorias;
	}
}
