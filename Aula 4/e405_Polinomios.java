/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e405_Polinomios
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		double inicio, fim, incremento;
		int i;
		
		inicio = ReadDouble();
		fim = ReadDouble(inicio);
		
		System.out.print("Numero de elementos da tabela: ");
		i = read.nextInt();
		
		incremento = (fim - inicio)/(i-1);
		
		PrintTabela(inicio, fim, incremento);
		
	}
	
	public static double ReadDouble ()
	{
		double x;
		System.out.print("X inicial: ");
		x = read.nextDouble();
		return x;
	}
	
	public static double ReadDouble (double LimitInf)
	{
		double x;
		do
		{
		System.out.print("X final: ");
		x = read.nextDouble();		
	    }while(x <= LimitInf);
		return x;
	}
	public static void PrintTabela (double inicio, double fim, double i)
	{
		double poli1, poli2;
		
		System.out.println("------------------------------------");
		System.out.println("|   x   | 5x2+10x+3 | 7x3+3x2+5x+2 |");
		System.out.println("------------------------------------");
		
		for (double x=inicio ; x<=fim ; x+=i)
		{
			poli1 = polinomio1(x);
			poli2 = polinomio2(x);
			System.out.printf("| %5.1f | %9.2f | %12.3f |\n", x, poli1, poli2);
			System.out.println("------------------------------------");
		}
	}
	
	public static double polinomio1 (double x)
	{
		x = 5*Math.pow(x,2) + 10*x + 3;
		return x;
	}
	
	public static double polinomio2 (double x)
	{
		x = 7*Math.pow(x,3) + 3*Math.pow(x,2) + 5*x + 2;
		return x;
	}
	
}
