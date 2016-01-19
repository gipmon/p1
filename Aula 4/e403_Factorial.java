/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class ex403_Factorial
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		int M, fact;
		
		M = ReadInt(1,10);
		
		for(int i=1 ; i<=M ; i++)
		{
			fact = Factorial(i);
			System.out.printf("%d! = %d\n", i, fact);
		}
	
		
	}
	
	public static int Factorial (int num)
	{
		if (num==0)
			return 1;
		return num* Factorial(num-1);
	}
	
	public static int ReadInt (int LimitInf, int LimitSup)
	{
		int x;
		do
		{
		System.out.print("M [1,10]: ");
		x = read.nextInt();		
	    }while(x < LimitInf || x > LimitSup);
		return x;
	}
}
