/*
 * Programa de leitura de um char com validação e sem validação
 * Dev/Comentários © Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;

public class ex71_readChar{
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		char a;
		a=readCharSimply();
		System.out.println("Lido: "+a);
		a=readCharVal();
		System.out.println("Lido: "+a);
	}
	public static char readCharSimply(){ //sem validação
		char temp; //caracter temporário
		out.print("[S]Insira um char: ");
		temp = sc.nextLine().charAt(0); //le a linha inserida e no resultado da linha inserida devolve o caracter que se 
		//encontra na posição 0, exemplo "Universidade".charAt(0) devolve o valor 'U'
		return temp;
	}
	public static char readCharVal(){ //com validação
		char temp;
		String s = new String();
		do{
			out.print("[V]Insira um char: ");
			s=sc.nextLine();
		}while(s.length()!=1); //a função length premite a leitura do número de caracteres
		temp=s.charAt(0);
		//o raciocínio neste exemple consiste em se fazer a leitura da próxima linha inserida e verificar o número 
		//de caracteres inseridos, se o número de caracteres inseridos for diferente de 1 então será necessário inserir 
		//um novo valor, se igual a um então temos o nosso caracter que vai ser devolvido com a função charAt(POSICAO)
		return temp;
	}
}

