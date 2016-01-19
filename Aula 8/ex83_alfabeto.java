/*
 * Caracteres -> Alfabeto
 * Desenvolvimento e Comentários: Rafael Ferreira
 */
import static java.lang.System.*;
import java.util.*;

public class ex83_alfabeto{
/* 
    ->Formas de declar uma array Char como alfabeto:
  	
	char[] alfabeto ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
	char alfabeto[];
	alfabeto = new char[26];
	int i=0;
	
		for(char c = 'a'; c <= 'z'; c++) {
			alfabeto[i]='c';
			i++;
		}
	
	Nesta solução para o problema é criado uma Array de booleanos com o número de letras (maiusculas e minusculas) do alfabeto
	ingles e depois é verificado se é minuscula ou maiuscula, se minuscula entra num foor para comparar com o alfabeto em minusculas
	e se a comparação der verdadeiro é encontrada a posição que necessitávamos para colocar no array dos booleans a true;
	No final é percurrido o array de Booleans e imprimimos a solução.
	* Alguma dúvida: email!
*/	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		boolean alfabeto[];
		alfabeto = alfabeto_boolean();
		
		String frase = new String();
		out.print("Insira uma frase (Alfabeto Inglês): ");
		frase=sc.nextLine();
		double inicio = System.currentTimeMillis();
		
		for(int i=0; i<frase.length(); i++)
			alfabeto_equals(alfabeto, frase.charAt(i));
		
		caracteres_encontrados(alfabeto);	
		double fim = System.currentTimeMillis();
		out.println("\nTempo de execução: " + (fim-inicio));
	}
	
	public static void alfabeto_equals(boolean[] b, char a){
		
		if(Character.isLowerCase(a)){
			int i=0;
			for(char c='a'; c<='z'; c++){
				if(c==a){
					b[i] = true;
					break;
				}
				i++;
			}
		}else{
			int i=26;
			for(char c='A'; c<='Z'; c++){
				if(c==a){
					b[i] = true;
					break;
				}
				i++;
				
			}
		}
	}
	public static boolean[] alfabeto_boolean(){
		boolean tmp[];
		tmp = new boolean[52];
		
		for(int i=0; i<52; i++)
			tmp[i]=false;
		
		return tmp;
	}
	public static void caracteres_encontrados(boolean[] a){
		char[] alfabeto ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', 'A', 'B', 'C', 'D', 'E',	'F', 'G', 'H', 'I',	'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',	'V', 'W', 'X', 'Y', 'Z'};
		out.println("Aparecem na frase as letras: ");
		for(int i=0; i<a.length; i++)
			if(a[i])
				out.print(alfabeto[i]+" ");
		
	}
}

