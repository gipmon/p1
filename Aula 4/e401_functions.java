/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e401_functions
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		//To limit the velocity in the point 7.
		final int LightVelocity = 299792458;
	
		int option=123;	
		int n, m, i=0;
		double a, b, imc, Ec, Resi;
		boolean func4;
		ClearConsole();
		Options();
		
		do
		{
			if(option!=9)
			option = read.nextInt();

			//case Attemps>9 ClearConsole and RePrints
			if (i>9) { option = 9; i=0; }		
			
			switch (option)
			{
				case 1: 
					PosInteger(); 
					option=Again(); 
					break;
				case 2:
					ClearConsole();
					System.out.println("## Function #2 ##");
					System.out.println("## Given an interval, reads until an allowed number is the input. \n"); 
					System.out.print("Input the 1º number of the interval: ");
					n = read.nextInt();
					do
					{
						System.out.print("Input the 2º number of the interval: ");
						m = read.nextInt();
					}while(m==n);
	
					PosIntLimited(n,m);
					option=Again(); 
					break;
				case 3:
					ClearConsole();
					System.out.println("## Function #3 ##");
					System.out.println("## Given 2 real numbers, outputs the biggest number.\n");
					System.out.print("Input the 1º number: ");
					a = read.nextInt();
					System.out.print("Input the 2º number: ");
					b = read.nextInt();
					BiggestReal(a,b);
					option=Again();
					break;
				case 4:
					ClearConsole();
					System.out.println("## Fuction #4 ##");
					System.out.println("## Given a first number, checks if the that number was input again.\n");
					System.out.print("Input the base number: ");
					n = read.nextInt();
					func4 = BoolFunc(n);
					if (func4) System.out.printf("You did input the number %d\n", n);
					else System.out.printf("You didn't input the number %d\n", n);					
					option=Again();
					break;
				case 5:
					ClearConsole();
					System.out.println("## Fuction #5 ##");
					System.out.println("## Does N! for the number 'N' the user inputs.\n");
					System.out.print("Input a number: ");
					n = read.nextInt();
					m = Factorial(n);
					System.out.printf("\n%d!= %d \n", n, m);
					option=Again();
					break;
				case 6:
					ClearConsole();
					System.out.println("## Fuction #6 ##");
					System.out.println("## Given the weight and height, returns the body mass index (IMC).\n");
					do
					{
					System.out.print("Input weight (Kg): ");
					a = read.nextDouble();
					}while(a<=0);
					do
					{
					System.out.print("Input height (m) [Example:1,75]: ");
					b = read.nextDouble();
					}while(b<=0);
					
					imc = IMC( a, b);
					System.out.printf("\nThe IMC is: %.2f\n", imc);
					option=Again();
					break;
				case 7:
					ClearConsole();
					System.out.println("## Fuction #7 ##");
					System.out.println("## Given the mass and velocity, returns the kinetic energy of the body.\n");
					do
					{
					System.out.print("Input mass (Kg): ");
					a = read.nextDouble();
					}while(a<=0);
					do
					{
					System.out.print("Input velocity (m/s): ");
					b = read.nextDouble();
					}while(Math.abs(b)>LightVelocity);
					Ec = KineticEnergy( a, b);
					System.out.printf("Ec = %.2f Joules.\n", Ec);
					option=Again();
					break;
				case 8:
					ClearConsole();
					System.out.println("## Fuction #7 ##");
					System.out.println("## Given the potential difference and current, returns the resistance.\n");
					System.out.print("Potential difference (V): ");
					a = read.nextInt();
					a = Math.abs(a);
					do
					{
					System.out.print("Current (A): ");
					b = read.nextInt();
					}while(b<=0);
					Resi = Resistance( a, b);
					System.out.printf("R = %.2f Ohm.\n", Resi);
					option=Again();
					break;
				case 9:
					Options(); 
					option=123;	
					break;
				default: 
					break;
			}
			i++;
		}while(option!=0);
		
	}
	
	public static void Options()
	{
		ClearConsole();
		System.out.println("## Function Program ##");
		System.out.println("1 - Reads until a positive integer number is the input.");
		System.out.println("2 - Given an interval, reads until an allowed number is the input.");
		System.out.println("3 - Given 2 real numbers, outputs the biggest number.");
		System.out.println("4 - Given a first number, checks if the that number was input again.");
		System.out.println("5 - Does N! for the number 'N' the user inputs.");
		System.out.println("6 - Given the weight and height, returns the body mass index (IMC).");
		System.out.println("7 - Given the mass and velocity, returns the kinetic energy of the body.");
		System.out.println("8 - Given the potential difference and current, returns the resistance.");
		System.out.println("0 - Press to EXIT.");
		System.out.print("Your Option: ");
	}
	
	public static double Resistance (double potenc, double current)
	{
		double resist;
		resist = potenc/current;
		return resist;
	}
	
	public static double KineticEnergy (double mass, double velocity)
	{
		double kinetic;
		
		kinetic = (mass*Math.pow(velocity, 2))/2;
		
		return kinetic;
	}
	
	public static double IMC (double kg, double m)
	{
		double imc;
		imc= kg/(Math.pow(m, 2));
		return imc;
	}
	
	public static int Factorial (int num)
	{
		if (num==0)
			return 1;
		return num* Factorial(num-1);
	}
	
	public static boolean BoolFunc (int x)
	{
		int y;
		boolean equal = false;
		System.out.println("\n Input numbers (To exit press '0') ");
		do
		{
			System.out.print("N: ");
			y = read.nextInt();
			if (y==x) equal=true;	
		}while(y!=0);
		
		return equal;
	}
	
	public static void BiggestReal (double a, double b)
	{
		if (a>b)
		System.out.printf("The biggest real number you input was: %.2f\n", a);
		else
		System.out.printf("The biggest real number you input was: %.2f\n", b);
	} 
	
	public static void PosIntLimited (int x, int y)
	{
		int num, swap;
		
		if (x>y)
		{
			swap = x;
			x = y;
			y = swap;
		}
		System.out.printf("\nTo exit input a number contained in the interval: [%d, %d] \n", x, y);
		do
		{
			num = read.nextInt();
		}while(num < x && num > y);
	}

	public static void PosInteger()
	{
		int x;
		ClearConsole();
		System.out.println("## Function #1 ##");
		System.out.println("## Reads until a positive integer number is the input.\n");
		do
		{
		System.out.print("Input a number: ");	
		x = read.nextInt();
		}while(x<=0);
	}
			
 	public static int Again()
	{
		char op;
		read.nextLine();
		do
		{
		System.out.print("Print options again (Y/N)?");
		op = read.nextLine().charAt(0);
		ClearConsole();
		}while (op != 'Y' && op != 'N' && op != 'y' && op != 'n');
		
		switch(op)
		{
			case 'Y': return 9;
			case 'y': return 9;
			case 'N': return 0;
			case 'n': return 0;
			default: return 0;
		}
	}

	public static void ClearConsole()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	
}
