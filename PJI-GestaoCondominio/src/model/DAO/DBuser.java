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
	static String comentario7 = "\nO vizinho está com goteiras que estão estragando o teto do meu banheiro. \nDATA: 19/08/2022 \nPOR: ERIN PARKER, 43B";
	static String comentario8 = "\nEm outubro, teremos uma festinha de Halloween paras crianças! \nDATA: 30/08/2022 \nPOR: DANTE GASPAR, 82C";
	static String comentario9 = "\nO novo parquinho está muito bom, meu filho adorou. \nDATA: 28/08/2022 \nPOR: ELIZABETH WEBBER, 62B";
	static String comentario10 = "\nAcho que o prédio deveria ter uma churrasqueira nova. \nDATA: 20/08/2022 \nPOR: FERNANDO CARVALHO, 64D";

	public static String verificaUsuario (String codUsuario) {
		int verificaUsuario = 0;
		
		switch(codUsuario) {
		
		case "Cesar Cohen":
			verificaUsuario=1;
		break;
		
		case "Beatrice Portinari":
			verificaUsuario=1;
		break;
		
		case "Brulio Cevero":
			verificaUsuario=1;
		break;
		
		default:
			verificaUsuario=0;
		break;		
		}
		
		if(verificaUsuario==1) {
			return codUsuario;
		} else {
			JOptionPane.showMessageDialog(null, "Usuario não existe");
			System.exit(0);
			return codUsuario;
		}
	}

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

