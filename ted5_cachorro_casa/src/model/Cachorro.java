package model;

import java.util.Random;

public class Cachorro {
	
	private String nome;
	private String raca;
	private String sexo;
	private int idade;
	private int energia = 10;
	private int numeros_filhotes = 0;
	
	public Cachorro(String nome, String raca, String sexo, int idade) {
		
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.idade = idade;
		
	}
	
	public Cachorro() {}
	
	//NOME
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//RAÇA
	public String getRaca() {
		return this.raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	//SEXO
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	//IDADE
	public int getIdade() {
		return this.idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	//ENERGIA
	public int getEnergia() {
		return this.energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	//FILHOTES
	public int getNumeros_filhotes() {
		return this.numeros_filhotes;
	}
	public void setNumeros_filhotes(int numeros) {
		this.numeros_filhotes = numeros;
	}
	
	//TOSTRING
	public String toString() {
		return "Nome: "+this.nome+"\nRaça: "+this.raca+
				"\nSexo: "+this.sexo+"\nIdade: "+this.idade+
				"\nEnergia: "+this.energia+"\nNúmero de Filhos: "+this.numeros_filhotes+"\n";
	}
	
	//COMER
	public int comer(int comida) {
		if (this.energia <= 50){
			
			this.energia = this.energia + comida;
		}else {
			return this.energia;
		}
		
		return this.energia;
	}
	
	//BRINCAR
	public int brincar(int brincadeira) {
		if (this.energia >= 40) {
			this.energia = this.energia - brincadeira;
		}
		else {
			return this.energia;
		}
		
		return this.energia;
	}
	
	//PODE_CRUZAR
	public boolean podeCruzar(Cachorro cachorro) {
		boolean situacao = false;
		
		if(this.getSexo().equals(cachorro.getSexo())) {
			
		}
		else {
			if(cachorro.getIdade() >=1 && cachorro.getIdade() <=9) {
				
				if(this.raca.equals(cachorro.getRaca())) {
					
					if(this.getEnergia() >=80 && cachorro.getEnergia() >= 80) {
						
						if(this.getIdade() >=1 && this.getIdade() <=9) {
							situacao = true;
						}
					}
				}
			}
		}
		
		return situacao;
	}
	
	//CRUZAR
	public int cruzar(Cachorro parceiro) {
		Random aleatorio = new Random();
		int filhotes = 0;
		
		if (this.podeCruzar(parceiro) == true) {
			this.setEnergia(this.getEnergia()-50);
			parceiro.setEnergia(parceiro.getEnergia()-50); 
			
			filhotes = filhotes+aleatorio.nextInt((10-3)+1)+3;
			this.setNumeros_filhotes(this.getNumeros_filhotes()+filhotes);
			parceiro.setNumeros_filhotes(parceiro.getNumeros_filhotes()+filhotes);
		}
		
		return filhotes;
	}
	

}
