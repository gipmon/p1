/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e306_MinMax
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		
		double xTemp;
		int x = 0;
		
		int sum = 0, NotRead = 0, NumberBeforeX;
		
		int biggest = 0; 
		int smallest = Integer.MAX_VALUE;	
		
		boolean TooBig=false;
		
		System.out.print("Introduza numeros. \n");
		
		do
		{	
			NumberBeforeX = x;
			
			xTemp = read.nextDouble();
			xTemp = Math.floor(xTemp);
			if(xTemp <= Integer.MAX_VALUE && xTemp > 0) x = (int)xTemp;
			else
			{
				x = 0;
				System.out.println("Este numero nao foi lido");
				NotRead++;
			}			
		
			if (x < smallest  &&  x != 0) smallest = x;				

			if (x > biggest) biggest = x;
			
			if((sum + x) > Integer.MAX_VALUE || (sum + x) < 0)
			{
				TooBig = true;
				System.out.printf("\n Valor da soma superior ao permitido. \n Soma Anterior = %d\n", sum);
			}
			else sum = sum + x;
		}
		while ((NumberBeforeX*2 != x || x == 0) && !TooBig);
			
		if(!TooBig)
		{
			System.out.printf("\n A soma dos numeros lidos foi: %d \n", sum);
			System.out.printf(" Os numeros que forçaram a paragem da leitura foram: %d e %d \n", NumberBeforeX, x);
		}
		
		System.out.printf("\n Não foram lidos: %d \n", NotRead);
		System.out.printf(" Min = %d \n Max = %d \n", smallest, biggest);
	}
}
