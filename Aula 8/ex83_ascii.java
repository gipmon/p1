/*
 * Caracteres -> ASCII
 * Desenvolvimento e Comentários: Bruno Reis
 * Revisão: Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;
public class ex83_ascii{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		
	String s = new String();
	
	//Criamos um array booleano (tamanho = 256) -> tamanho da tabela ASCII
	Boolean caracteres[] = new Boolean[256];
	
	//Lemos uma string
	out.print("Insira uma frase: ");
	s = sc.nextLine();
	double inicio = System.currentTimeMillis();
		
	//Criamos um ciclo for para atribuir "false" a todas as posições do array
	for(int i = 0; i < caracteres.length; i++)
		caracteres[i]= false;
	
	//Este ciclo for serve para atribuir "true" as posições do array que têm o número  
	//da tabela ASCII correspondente aos caracteres existentes na string
	for (int i=0; i < s.length(); i++)
		caracteres[(int)s.charAt(i)]= true;
	
	out.println("As letras que apareceram na frase inserida são: ");
	//Este ciclo percorre todo o array, e imprime no ecrã os caracteres correspondentes 
	//ás posições que têm o valor "true".
	for (int i=0; i < caracteres.length;i++)
		if(caracteres[i]== true)
		    out.printf("%c  ",(char)i);
	
	double fim = System.currentTimeMillis();
	out.println("\nTempo de execução: " + (fim-inicio));
	
	}
}

