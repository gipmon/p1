/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e304_Factorial
{
	public static void main (String[] args)
	{
		Scanner read = new Scanner(System.in);

		int x, y = 1;
		
		do
		{
			System.out.print("Introduza um numero: ");
			x = read.nextInt();
		}
		while(x <= 0 || x > 10);
		
		for(int z=1 ; z<=x ; z++)
		{
			y = y * z;
			System.out.printf("%d! = %d\n", z, y);
		}
	}	
}
