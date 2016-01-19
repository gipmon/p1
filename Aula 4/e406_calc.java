/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e406_calc
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		int option=1;
		char op;
		double num1, num2, print;
		
		do
		{
			System.out.println("## Calculadora ##");
			System.out.print("Operando 1: ");
			num1 = read.nextDouble();
			
			op = Options();
			
			switch(op)
			{	
				case 'I':
					print = inver(num1);
					System.out.printf("## %.2f invertido = %.2f \n", num1, print);	
					Again();
					break;
				case '!':
					print = Fatorial((int)num1);
					System.out.printf("## %d! %d \n", (int)num1, (int)print);
					Again();
					break;
				case 'R':
					print = sqrRoot(num1);
					System.out.printf("## Raiz quadrada de %.2f é: %.2f \n", num1, print);
					Again();
					break;
				case '+':
					num2 = GetNum2();
					print = add(num1,num2);
					System.out.printf("## %.2f + %.2f = %.2f \n", num1, num2, print);
					Again();
					break;
				case '-':
					num2 = GetNum2();
					print = sub(num1,num2);
					System.out.printf("## %.2f - %.2f = %.2f \n", num1, num2, print);
					Again();
					break;
				case '*':
					num2 = GetNum2();
					print = mult(num1,num2);
					System.out.printf("## %.2f * %.2f = %.2f \n", num1, num2, print);
					Again();
					break;
				case '/':
					num2 = GetNum2();
					print = div(num1,num2);
					System.out.printf("## %.2f / %.2f = %.2f \n", num1, num2, print);
					Again();
					break;
				case 'P':
					num2 = GetNum2();
					print = power(num1,num2);
					System.out.printf("## %.2f^%.2f = %.2f \n", num1, num2, print);
					Again();
					break;	
				case '0':	
					option = 0;
					break;
			}
		}while(option!=0);
	}
	
	public static double GetNum2()
	{
		double x;
		System.out.print("Operando 2: ");
		x = read.nextDouble();
		return x;
	}
	
	public static void Options2()
	{
		System.out.println("## Escolha a Operação ##");
		System.out.println("+ - Adição.");
		System.out.println("- - Subtração.");
		System.out.println("* - Multiplicação.");
		System.out.println("/ - Divisão.");
		System.out.println("I - Inversão de sinal.");
		System.out.println("P - Potência (x^y).");
		System.out.println("! - Fatorial (n!).");
		System.out.println("R - Raiz Quadrada.");
		System.out.println("0 - EXIT.");
	}
	
	public static char Options()
	{
		char op;
		int temp=0;
		read.nextLine();
		System.out.println("## Escolha a Operação ##");
		System.out.println("+ - Adição.");
		System.out.println("- - Subtração.");
		System.out.println("* - Multiplicação.");
		System.out.println("/ - Divisão.");
		System.out.println("I - Inversão de sinal.");
		System.out.println("P - Potência (x^y).");
		System.out.println("! - Fatorial (n!).");
		System.out.println("R - Raiz Quadrada.");
		System.out.println("0 - EXIT.");
		do
		{
			System.out.print("Operação: ");
			op = read.nextLine().charAt(0);
			temp++;
			if (temp==10)
			{
				ClearConsole();
				Options2();
			}
		}while(op != '+' && op != '-' && op != '*' && op != '/' && op != 'I' && op != 'P' && op != '!' && op != 'R' && op != '0');
	
		return op;
	}
	
	public static double inver (double num)
	{
		num = num *-1;
		return num;
	}
	
	public static double power (double x, double y)
	{
		x = Math.pow(x,y);
		return x;
	}
	
	public static int Fatorial (int num)
	{
		num = Math.abs(num);
		if (num==0)
			return 1;
		return num* Fatorial(num-1);
	}
	
	public static double sqrRoot(double num)
	{
		num = Math.sqrt(num);
		return num;
	}
	
	public static double sub(double op1, double op2)
	{
		double x;
		x = op1-op2;
		return x;
	}
	
	public static double add(double op1, double op2)
	{
		double x;
		x = op1+op2;
		return x;
	}	
	
	public static double mult(double op1, double op2)
	{
		double x;
		x = op1*op2;
		return x;
	}
	
	public static double div(double op1, double op2)
	{
		double x;
		x = op1/op2;
		return x;
	}
	
	 	public static char Again()
	{
		char op;
		read.nextLine();
		do
		{
		System.out.print("Mais Calculos (Y/N)?");
		op = read.nextLine().charAt(0);
		ClearConsole();
		}while (op != 'Y' && op != 'N' && op != 'y' && op != 'n');
		
		switch(op)
		{
			case 'Y': return '9';
			case 'y': return '9';
			case 'N': return '0';
			case 'n': return '0';
			default: return '0';
		}
	}
	
	public static void ClearConsole()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}		
}
