package br.com.poli;

// LPOO 2020.3
// desenvolvido por: Pedro Hirschle e Tito Sales
import java.util.Scanner;
import br.com.poli.InterfaceJogo;
import br.com.poli.Interface;
import br.com.poli.InterfaceJogador;


public class Partida {

	Scanner sc = new Scanner(System.in);

	private Jogador jogador1;
	private Jogador jogador2;
	private boolean fimDeJogo ;
	private String jogadorDaVez;
	private Tabuleiro tabuleiro;
        
        private static String assinatura; // nome dos desenvolvedores pro print final (pra quando upar em algum git da vida)
	
	public Partida(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
	}

        public void setAssinatura(String nomeDevs){
            this.assinatura = nomeDevs;
        }
        
        public String getAssinatura(){
            return this.assinatura;
        }

	public boolean getFimDeJogo() {
		return this.fimDeJogo;
	}

	public void setFimDeJogo(boolean acabou) {
		this.fimDeJogo = acabou;
	}

	public int getPosiçao() {
		return tabuleiro.getPosiçao();
	}

	public String getJogadorDaVez() {
		return jogadorDaVez;
	}

	public int getNumJogador() {
		return tabuleiro.getNumJogador();
	}

	public void fazerJogada(int jogada, String jogadorDaVez, int numJogador) { // metodo que alterna os jogadores e
									          // chama o deslizar e mostrar

		for (int cont = 1; cont <= 42; cont++) {
			if (cont % 2 != 0) {
				jogadorDaVez = jogador1.getNome();
				numJogador = 1;
			} else {
				numJogador = 2;
				jogadorDaVez = jogador2.getNome();
			}
			System.out.println("Digite a posição da jogada");
			jogada = sc.nextInt();
			
			if(tabuleiro.checarJogada( jogada,  numJogador) == -1) {
				tabuleiro.mostrar();
			}else {
				tabuleiro.verificarVitoriaLinha(tabuleiro.getPosiçao2(),jogada, numJogador, jogadorDaVez);
				tabuleiro.verificarVitoriaColuna(tabuleiro.getPosiçao2(),jogada, numJogador, jogadorDaVez);
				tabuleiro.verificarVitoriaDiagonal(tabuleiro.getPosiçao2(),jogada, numJogador, jogadorDaVez);
				tabuleiro.verificarEmpate();
				tabuleiro.mostrar();
                                
				if(tabuleiro.getFimDeJogo()== true) {
                                    this.setAssinatura("Antônio Tito Sales e Pedro Melo Hirschle");
                                    System.out.println("");
                                    System.out.println("desenvolvido por: "+this.getAssinatura()+".");
					System.exit(0);
				}
			}					

			System.out.println("-> O jogador " + numJogador + " (" + jogadorDaVez + ") fez a jogada " + jogada);
			System.out.println("");

		}
	}

}
