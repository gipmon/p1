/*
 * Programa de inversao de Arrays
 * Desenvolvimento: Bruno Reis
 * Revisão e Comentários: Rafael Ferreira
 */
import static java.lang.System.*;
import java.util.*;

public class ex81_invert_v2{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		int a[] = new int[10];
		int n;
		n = lerarray(a);
		//faz a leitura da array e retorna o numero de entradas lidas para a intrepetação da impressao da array invertida
		imprimearray(a, n);	
		
	}
	
	public static int lerarray(int a[])
	{
		int i = 0;
		
		do {
			out.printf("Introduza o valor da posição a[%d]: ", i);
			a[i] = sc.nextInt();
			i++; 
		}while(i < a.length && a[i-1] >= 0 );
	  
		return i; 			 
	}
	
	public static void imprimearray(int a[], int n)
	{ 
		int i;
		for(i = 8 ; i > (9-n) ; i--)
			out.printf("a[%d]: %d \n", (8 - i), a[i-(10-n)]);
		
	}
}	
