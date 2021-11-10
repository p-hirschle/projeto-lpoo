package br.com.poli;
import java.util.Scanner;

//desenvolvido por Pedro Hirschle e Tito Sales
//lpoo 2020.3

public class Lig4 {
    
public static void main(String[] args) {
		
                System.out.println("------------------------------------------------- LIG 4 ---------------------------------------------------------");
                System.out.println(" Regras:");
                System.out.println("1 - Os jogadores devem selecionar a coluna onde querem realizar a jogada.");
                System.out.println("2 - O primeiro jogador a realizar uma ligação direta entre 4 pontos de sua numeração, vence.");
                System.out.println("3 - Deve-se selecionar apenas as posições da dimensão do tabuleiro (0 a 6) caso contrário, o jogador perde a vez.");
                System.out.println("4 - Caso acabem as posições disponíveis e ninguém tenha conseguido a ligação completa, ocorre um empate.");
                System.out.println("");
                System.out.println("");
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o nome do jogador 1:");
		String nome = sc.nextLine();  // recebe o nome do jogador pelo usuario

		Jogador jogador1 = new Jogador(nome, 1);  // cria o jogador herdando da classe pessoa

		System.out.println("Insira o nome do jogador 2:");  
		nome = sc.nextLine(); // recebe o nome do jogador pelo usuario

		Jogador jogador2 = new Jogador(nome, 2);  // cria o jogador herdando da classe pessoa

		System.out.println(jogador1);   // uso do metodo toString
		System.out.println(jogador2);   // uso do metodo toString
		
		Tabuleiro t0 = new Tabuleiro();  // instancia o tabuleiro
		Partida p0 = new Partida(jogador1, jogador2, t0); // instancia a partida passando os jogadores com seus nomes e valores, e o tabuleiro
                
                System.out.println("");		
		System.out.println("    --- INÍCIO DO JOGO ---");
		System.out.println("");
		System.out.println("(os jogadores devem inserir a posição agora)");
		System.out.println("");

                
		t0.mostrar(); // mostra o tabuleiro

			p0.fazerJogada(p0.getPosiçao(),p0.getJogadorDaVez(), p0.getNumJogador()); // o jogo inteiro rodado aqui
                       sc.close(); 
                     }                  
}
