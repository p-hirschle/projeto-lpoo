package br.com.poli;
// LPOO 2020.3
// desenvolvido por: Pedro Hirschle e Tito Sales
public class Jogador extends Pessoa {
	
	private int jogador;

	public Jogador(String nome, int jogador) {
		super(nome);
		this.jogador = jogador;
	}
	
  
	public Jogador(String nome) {
		super(nome);
	}

	
	public int getJogador() {
		return jogador;
	}

	public void setJogador(int jogador) {
		this.jogador = jogador;
	}
	
	
	@Override
	public String toString() {
		
		return "(" + this.jogador+")" + super.toString()  ;
	}

}
