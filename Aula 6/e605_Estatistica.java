/*
 * Desenvolvido por Diogo Corte
 */
import java.util.*;

public class e605_Estatistica 
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args) 
	{
		int counter=0,num;
		Estatistica stats = new Estatistica();
		stats.minimo = Integer.MAX_VALUE;
		stats.maximo = 0;
		
		do
		{
			do
			{
				System.out.print("N: ");
				num= read.nextInt();	
			}while(num<0);
			if(num!=0)
			{ 	
				counter++;	
				stats.media += num;
				if(stats.minimo>num) stats.minimo=num;
				if(stats.maximo<num) stats.maximo=num;
			}
		}while(num!=0 || counter<1);
		stats.media/=counter;
		
		System.out.printf("Foram introduzidos %d numeros válidos.\n", counter);
		System.out.printf("O Máximo foi: %d \n", stats.maximo);
		System.out.printf("O Minimo foi: %d \n", stats.minimo);
		System.out.printf("A Média foi: %.2f \n", stats.media);
		
	}
}
class Estatistica
{
	int maximo;
	int minimo;
	double media;
}

