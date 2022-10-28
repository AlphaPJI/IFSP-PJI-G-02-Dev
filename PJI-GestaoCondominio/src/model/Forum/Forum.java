package model.Forum;

import java.util.List;

import javax.swing.JOptionPane;

import model.Condominio.ForumGS;

public class Forum {

	public void Forum() {
		Categoria categoria = new Categoria();
		categoria.getCategoria();
		String escCategorias[] = new String[10];
		int x = 0;
		for(ForumGS c : Categoria.getCategoria()) {
			//System.out.println("Categoria: " + c.getTituloCategoria());]
			escCategorias[x] = c.getTituloCategoria();
			x++;
			
		}
		Object categ = JOptionPane.showInputDialog(null, "Escolha a categoria do forúm", " ", JOptionPane.INFORMATION_MESSAGE, null, escCategorias, escCategorias[0]);
		
		/*int codTelaInicio = JOptionPane.showOptionDialog(null, "Escolha a categoria do forúm", "Gestão de Condominio",
		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
		null, escCategorias, escCategorias[0]*/
	
		
	}
	
	
}
