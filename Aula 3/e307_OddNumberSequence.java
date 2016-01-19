/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e307_OddNumberSequence
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		
		int num=1;
		boolean Odd = true;
		
		System.out.println("\n ## Verifica se a sequência de numeros introduzida é constituida apenas por numeros impares ## ");
		System.out.println("Introduza numeros (0 para sair). ");
		
		while(num != 0)
		{
			num = read.nextInt();
			if( (num%2)==0 && num!=0 ) Odd=false;
		}
		
		if (Odd)
		System.out.println("A sequência de números é exclusivamente constituída por números ímpares.");
		else
		System.out.println("A sequência de números não é exclusivamente constituída por números ímpares.");
		
		
	}
}
