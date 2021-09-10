package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Cachorro;

public class Casa {
	
	//MANIPULA��O
	public Cachorro manipularCao(Cachorro cachorro, ArrayList<Cachorro> caes) {
		
		int menu = 0;
		
		while(menu == 0 ) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Mostrar Dados do C�o: "+
																"\n2 - Alimentar: "+
																"\n3 - Brincar: "+
																"\n4 - Cruzar: "+
																"\n5 - Menu Inicial: "+
																"\n"));
			//MENU MANIPULAR
			switch (opcao) {
			
				//MOSTRAR
				case 1 :
				JOptionPane.showMessageDialog(null,cachorro.toString());
				break;
				
				//COMER
				case 2:
					//ENERGIA BAIXA
					if(cachorro.getEnergia() <= 50) {
						int comida = Integer.parseInt(JOptionPane.showInputDialog("Escolha a Comida: \n"
																					+ "1 - Ra��o  \n"
																					+ "2 - Carne  \n"
																					+ "3 - Legumes  \n"));
						//MENU COMIDA
						switch(comida) {
							//RA��O	
							case 1:
								JOptionPane.showMessageDialog(null,"Energia Atual: "+cachorro.comer(50));
							break;
							//CARNE
							case 2:
								JOptionPane.showMessageDialog(null,"Energia Atual: "+cachorro.comer(40));
							break;
							//LEGUMES
							case 3:
								JOptionPane.showMessageDialog(null,"Energia Atual: "+cachorro.comer(30));
						}
					}
					//ENERGIA ALTA
					else {
						JOptionPane.showMessageDialog(null, "O c�o n�o precisa comer");
					}
				//FIM COMER
				break;
				
				//BRINCAR	
				case 3:
					//ENERGIA BAIXA
					if(cachorro.getEnergia() <= 40) {
					JOptionPane.showMessageDialog(null, "O c�o n�o pode brincar");
					}
					
					else {
						int brincadeira = Integer.parseInt(JOptionPane.showInputDialog("Escolha a Comida: \n"
																						+ "1 - Buscar Bolinha = \n"
																						+ "2 - Saltar = \n"
																						+ "3 - Girar pelo ch�o = \n"));
						switch(brincadeira) {
							//BUSCAR BOLINHA
							case 1:
								JOptionPane.showMessageDialog(null,"Energia Atual: "+cachorro.brincar(30));
							break;
							//SALTAR
							case 2:
								JOptionPane.showMessageDialog(null,"Energia Atual: "+cachorro.brincar(20));
							break;
							//GIRAR PELO CH�O
							case 3:
								JOptionPane.showMessageDialog(null,"Energia Atual: "+cachorro.brincar(10));
							break;
						}
					}
				//FIM BRINCAR
				break;
				
				//PODE CRUZAR
				case 4:
					
					boolean decisaoCruzar = false;
					
					for(int cao = 0; cao < caes.size(); cao++) {
							
						if (cachorro.podeCruzar(caes.get(cao)) == true) {
								
							JOptionPane.showMessageDialog(null," Pode cruzar com "
															+"parceiro n�mero: "+(cao+1)+"\nNome: "+caes.get(cao).getNome());
							decisaoCruzar = true;
						}
					}
					
					//CRUZAR
					if (decisaoCruzar == true) {
						int cruzarParceiro = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero do parceiro que dedeja cruzar: ? "));
						JOptionPane.showMessageDialog(null,"Filhos Gerados: "+cachorro.cruzar(caes.get(cruzarParceiro - 1)));
					}
					else {
						JOptionPane.showMessageDialog(null,"N�o Pode Cruzar");
					}
					
				//FIM CRUZAR
				break;
				
				//VOLTAR PRO MENU INICIAL
				case 5:
					menu = 1;
					break;
			//FIM SWITCH
			}
		//FIM DO WHILE	
		}
		return cachorro;
	//FIM M�TODO
	}
	
	//EXECUTAR
	public static void main(String args[]) {
		//INST�NCIAS 
		Casa casa1 = new Casa();
		ArrayList<Cachorro> cachorros = new ArrayList<Cachorro>();
		Cachorro cachorro;
		
		int contador = 0;
		
		//MENU
		while (contador == 0) {
			
			 int operacao = Integer.parseInt(JOptionPane.showInputDialog("1 - CADASTRAR C�O: "+
			 "\n2 - LISTAR C�ES: "+"\n3 - SAIR DO PROGRAMA: "));
			 
			 //CADASTRAR
			 switch (operacao) {
			 	case 1:
			 		cachorro = new Cachorro();
					 
					 cachorro.setNome(JOptionPane.showInputDialog("Digite o nome do C�o: "));
					 cachorro.setRaca(JOptionPane.showInputDialog("Ra�a: "));
					 cachorro.setSexo(JOptionPane.showInputDialog("Sexo do C�o: "));
					 cachorro.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
					 
					 cachorros.add(cachorro); 
				break;
				
			 	case 2:
			 		//LISTAR
			 		for (int i = 0; i < cachorros.size() ; i++) {
						 JOptionPane.showMessageDialog(null,"---------- C�O N� "+(i+1)+"----------\n"+cachorros.get(i));
					 }
					 
					 //ESCOLHER C�O
					 int opcaoCao = Integer.parseInt(JOptionPane.showInputDialog("Qual C�o deseja Selecionar? "));
					 //GUARDAR C�O
					 Cachorro parceiro = cachorros.get(opcaoCao - 1);
					 //FUN��O MANIPULAR
					 casa1.manipularCao(parceiro, cachorros);
				break;
			 	case 3:
			 		System.exit(operacao);
					//contador = 1;
				break;
			 }
			 
		}
		
	}

}
