/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e305_Tabuada
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		int N, MultiplyTemp;

		do
		{
			System.out.print("Introduza um numero N (0<N<100): ");
			N = read.nextInt();
		}
		while(N <= 0 || N >= 100);

		System.out.println("\n   ------------------");
		
		if (N == 1)	System.out.printf("   | Tabuada do  %2d |\n", N);
		else System.out.printf("   | Tabuada dos %2d |\n", N);
		
		System.out.println("   ------------------");

		for(int i=1 ; i<=10 ; i++)
		{
			MultiplyTemp = i * N;
			System.out.printf("   | %2d x %2d |  %3d |\n", N, i, MultiplyTemp);
		}

		System.out.println("   ------------------");
	}
}
