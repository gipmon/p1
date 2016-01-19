/*
 * Programa de análise dos caracteres de uma frase inserida
 * Nº char uppercase, char lowecase, char isdigit
 * N vogais e consuantes
 * Dev/Comentários © Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;

public class ex72_AnaliseChar{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		out.println("Análise de uma frase \n");
		
		//Variáveis e Leitura da frase
		String frase = new String();
		frase=LerString(); //Leitura da frase
		
		//Contagem do tipo CountCaracteres
		CountCaracteres contagem = NumeroCaracteres(frase); //defenição da variável contagem
		out.printf("\nNúmero de caracteres minúsculos -> %2d \nNúmero de caracteres maiúsculos -> %2d \nNúmero de caracteres numéricos -> %2d\n\nNúmero de vogais -> %2d\nNúmero de consuantes -> %2d ",contagem.minusculas,contagem.maiusculas,contagem.numericos,contagem.vogais,contagem.consoantes);
		 
	}
	public static String LerString(){
		String s = new String();
		out.print("Frase de entrada -> ");
		s=sc.nextLine();
		return s;
	}
	public static CountCaracteres NumeroCaracteres(String a){
		char b;
		//http://docs.oracle.com/javase/1.4.2/docs/api/java/lang/Character.html
		CountCaracteres count = new CountCaracteres();
		for(int i=0; i<a.length(); i++){
			//Caracter na posicao i na string a
			b=a.charAt(i);
			//Contagem
			if(Character.isUpperCase(b))
				count.maiusculas++;
			else if(Character.isLowerCase(b))
				count.minusculas++;
			else if(Character.isDigit(b))
				count.numericos++;
			//voagais e consoantes
			if(isVowel(b))
				count.vogais++;
			else
				count.consoantes++;
			//Contagem
		}
		return count;
	}
	public static boolean isVowel(char c){
		c = Character.toLowerCase(c);
		//http://docs.oracle.com/javase/6/docs/api/java/lang/Character.html#toLowerCase(char)
		
		if(c=='a' || c=='e' || c=='i' || c=='o'|| c=='u')
			return true;
		else
			return false;
	}
}
class CountCaracteres{
	int maiusculas, minusculas, numericos, vogais, consoantes;
}
