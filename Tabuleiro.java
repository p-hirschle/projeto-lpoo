
package br.com.poli;

// LPOO 2020.3
// desenvolvido por: Pedro Hirschle e Tito Sales
import java.util.Scanner;

public class Tabuleiro {

	public Tabuleiro() {

	}

	private boolean fimDeJogo = false;
	private int l;
	private int posiçao;
	private int numJogador;
	private final int[][] dimensaoTabu = new int[6][7];
	private Partida partida;
	Scanner scan = new Scanner(System.in);
	

	public int getPosiçao() {

		return posiçao;
	}

	public void setFimDeJogo(boolean fimDeJogo) {
		this.fimDeJogo = fimDeJogo;
	}

	public boolean getFimDeJogo() {
		return this.fimDeJogo;
	}

	public int getPosiçao2() {
		return l;
	}

	public int getPosicao(int x, int y) {

		return dimensaoTabu[x][y];
	}

	public int getNumJogador() {

		return numJogador;
	}
        

	public int mostrar() { // metodo que vai mostrar o tabuleiro em suas dimensoes
		System.out.println("  (0) (1) (2) (3) (4) (5) (6) ");
		for (int[] dimensaoTabu1 : dimensaoTabu) {
			for (int c = 0; c < 7; c++) {
				System.out.print(" | " + dimensaoTabu1[c]);
			}
			System.out.println(" | ");
		}
		return 0;
	}

	public int checarJogada(int jogada, int numJogador) {  // metodo que checa se a posiçao escolhida é valida (entre 0 a 6)

            if (jogada > 6 || dimensaoTabu[0][jogada] != 0){
                                             
			 System.out.println(" ---- POSIÇÃO INVÁLIDA ----");
                         return -1;
                                
            }
                        else{
                     
                               
              
                return deslizar2(jogada, numJogador);
                                
    }

        }
	public boolean verificarEmpate() {   // metodo que verifica se houve um empate (basta verificar ultima linha)

		if (this.getPosicao(0, 0) == 0 || this.getPosicao(0, 1) == 0 || this.getPosicao(0, 2) == 0
				|| this.getPosicao(0, 3) == 0 || this.getPosicao(0, 4) == 0 || this.getPosicao(0, 5) == 0
				|| this.getPosicao(0, 6) == 0) {

		} else {
			System.out.println("-------E M P A T E-------");
			System.out.println("   F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		return this.getFimDeJogo();
	}

	public int deslizar2(int jogada, int numJogador) { // metodo que de fato realiza a jogada no metodo fazerJogada 
                                                           //  (da classe Partida)
		                                           
		for (int x = 5; x >= 0; x--) { // inicia o contador na ultima linha e vai fazendo o decrescimo de linha com o
			if (dimensaoTabu[x][jogada] == 0) {
				dimensaoTabu[x][jogada] = numJogador;
				this.l = x;
				break;
			}
		}
		return dimensaoTabu[this.l][jogada];
	}

	public boolean verificarVitoriaLinha(int linha, int coluna, int jogadorDaVez, String nomeJogador) {  // metodo que verifica a vitoria na linha (vitoria horizontal)

		if (coluna <= 3 && this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha, coluna + 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna + 2) == jogadorDaVez
				&& this.getPosicao(linha, coluna + 3) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return partida.getFimDeJogo();
		}

		else if (coluna >= 1 && coluna <= 4 && this.getPosicao(linha, coluna - 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez && this.getPosicao(linha, coluna + 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna + 2) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (coluna >= 2 && coluna <= 5 && this.getPosicao(linha, coluna - 2) == jogadorDaVez
				&& this.getPosicao(linha, coluna - 1) == jogadorDaVez && this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha, coluna + 1) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (coluna >= 3 && this.getPosicao(linha, coluna - 3) == jogadorDaVez
				&& this.getPosicao(linha, coluna - 2) == jogadorDaVez
				&& this.getPosicao(linha, coluna - 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}
		return this.getFimDeJogo();
	}

	public boolean verificarVitoriaColuna(int linha, int coluna, int jogadorDaVez, String nomeJogador) {  // metodo que verifica a vitoria na coluna (vitoria vertical)

		if (linha <= 2 && this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 1, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 2, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 3, coluna) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (linha >= 1 && linha <= 3 && this.getPosicao(linha - 1, coluna) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez && this.getPosicao(linha + 1, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 2, coluna) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (linha >= 2 && linha <= 4 && this.getPosicao(linha - 2, coluna) == jogadorDaVez
				&& this.getPosicao(linha - 1, coluna) == jogadorDaVez && this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 1, coluna) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (linha >= 3 && this.getPosicao(linha - 3, coluna) == jogadorDaVez
				&& this.getPosicao(linha - 2, coluna) == jogadorDaVez
				&& this.getPosicao(linha - 1, coluna) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		} 
		return this.getFimDeJogo();
	}

	public boolean verificarVitoriaDiagonal(int linha, int coluna, int jogadorDaVez, String nomeJogador) { // metodo que verifica vitoria nas linhas e colunas (vitoria diagonal)

            
		if (linha <= 2 && coluna <= 3 && this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 1, coluna + 1) == jogadorDaVez
				&& this.getPosicao(linha + 2, coluna + 2) == jogadorDaVez
				&& this.getPosicao(linha + 3, coluna + 3) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (linha >= 1 && linha <= 3 && coluna >= 1 && coluna <= 4
				&& this.getPosicao(linha - 1, coluna - 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 1, coluna + 1) == jogadorDaVez
				&& this.getPosicao(linha + 2, coluna + 2) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (linha >= 2 && linha <= 4 && coluna >= 2 && coluna <= 5
				&& this.getPosicao(linha - 2, coluna - 2) == jogadorDaVez
				&& this.getPosicao(linha - 1, coluna - 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez
				&& this.getPosicao(linha + 1, coluna + 1) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		}

		else if (linha >= 3 && coluna >= 3 && this.getPosicao(linha - 3, coluna - 3) == jogadorDaVez
				&& this.getPosicao(linha - 2, coluna - 2) == jogadorDaVez
				&& this.getPosicao(linha - 1, coluna - 1) == jogadorDaVez
				&& this.getPosicao(linha, coluna) == jogadorDaVez) {

			System.out.println("----- Jogador (" + jogadorDaVez + ") "+nomeJogador+" venceu a partida! -----");
			System.out.println("     F I M   D E   J O G O");
			this.setFimDeJogo(true);
			return this.getFimDeJogo();
		} 
		return this.getFimDeJogo();
	}

}
