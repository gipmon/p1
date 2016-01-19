/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e303_EvenSum
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		int N, sum = 0;

		do
		{
			System.out.print("Introduza um numero: ");
			N = read.nextInt();
			if (N <= 0 || N > 1000) System.out.print("Apenas são aceites numeros do intervalo [1, 1000]. \n");
		}
		while(N <= 0 || N > 1000);

		for(int x=1; x<=N ; x++)
		{
			System.out.print((x * 2) + " ");
			sum = sum + x * 2;
		}

		System.out.printf("\n Soma = %d\n", sum);
	}
}
