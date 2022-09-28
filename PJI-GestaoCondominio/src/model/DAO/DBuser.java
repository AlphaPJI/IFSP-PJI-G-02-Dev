package model.DAO;

import javax.swing.JOptionPane;

public class DBuser 
{
	String codUsuario1 = "Cesar Cohen";
	String codUsuario2 = "Beatrice Portinari";
	String codUsuario3 = "Brulio Cevero";
	
	static String comentario1 = "\nO novo parquinho está muito bom, meu filho adorou. \nDATA: 28/08/2022 \nPOR: ELIZABETH WEBBER, 62B";
	static String comentario2 = "\nAcho que o prédio deveria ter uma churrasqueira nova. \nDATA: 20/08/2022 \nPOR: CHRISTOPHER COHEN, 71A";
	static String comentario3 = "\nO vizinho está com goteiras que estão estragando o teto do meu banheiro. \nDATA: 19/08/2022 \nPOR: ARTHUR CEVERO, 12C";
	static String comentario4 = "\nEm outubro, teremos uma festinha de Halloween paras crianças! \nDATA: 30/08/2022 \nPOR: JOUI JOUKI";
	static String comentario5 = "\nAcho que deveria ter sala de games. \nDATA: 31/08/2022 \nPOR: CESAR COHEN, 10D";
	static String comentario6 = "\nFamilia, meu cachorro fugiu, se alguém ver ele, não chegue perto. \nDATA: 17/08/2022 \nPOR: THIAGO FRITZ, 35A";
	static String comentario7 = "\nComo foi o final de semana de vocês? \nDATA: 11/08/2022, POR: ERIN PARKER, 43B\n\n=====================Respostas=====================\nEu fiz yoga \nDATA: 11/08/2022, POR: JOUI JOUKI, 59D";
	static String comentario8 = "\nAcho que o prédio deveria ser roxo \nDATA: 14/09/2022, POR: CESAR COHEN, 12a\n\n=====================Respostas=====================\nAcho que não, por mim seria verde \nDATA: 14/09/2022, POR: ARTHUR CEVERO, 12C";
	static String comentario9 = "\nReunião as 14h00 sobre a festa de dia das crianças. \nDATA: 01/10/2022 \nPOR: SÍNDICO SIDNEY, 10E";
	static String comentario10 = "\nTo com sono. \nDATA: 20/08/2022 \nPOR: LUCIANO CARVALHO, 64D";

	
	public static String acessaForum (String forum)
	{

		switch (forum)
		{
			case "1":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario1);
			break;
			
			case "2":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario2);
			break;
			
			case "3":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario3);
			break;
			
			case "4":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario4);
			break;
			
			case "5":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario5);
			break;
				
			case "6":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario6);
			break;
				
			case "7":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario7);
			break;
				
			case "8":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario8);
			break;
				
			case "9":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario9);
			break;
				
			case "10":
			JOptionPane.showMessageDialog(null, "================Comentário mais recente================" +comentario10);
			break;
			
			default:
			JOptionPane.showMessageDialog(null, "Fórum não existe");
			break;
		}
		return forum;
	}
}

