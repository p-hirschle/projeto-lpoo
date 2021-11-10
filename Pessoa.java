package br.com.poli;
// LPOO 2020.3
// dupla: Pedro Hirschle e Tito Sales   
    public class Pessoa {
	
	private String nome;

	public Pessoa(String nome) {

		this.nome = nome;

	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		
		return "O nome do jogador é "+ nome;
	}

}
