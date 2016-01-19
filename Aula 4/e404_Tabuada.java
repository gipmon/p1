/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e404_Tabuada
{
	static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int num;
	
		num = ReadInt(1, 99);
		PrintTabuada(num);

	}
	
	
	public static void PrintTabuada (int N)
	{
		int MultiplyTemp;
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
	
	
	public static int ReadInt (int LimitInf, int LimitSup)
	{
		int x;
		do
		{
		System.out.print("X [1,99]: ");
		x = read.nextInt();		
	    }while(x < LimitInf || x > LimitSup);
		return x;
	}
}
