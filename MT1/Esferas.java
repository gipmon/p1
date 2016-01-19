import java.util.Scanner;

public class Esferas
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double min, max;
		double vsum = 0;
		double ssum = 0;
		
		double r, i;
		System.out.print("Min Radius: ");
		min = sc.nextDouble();
		System.out.print("Max Radius: ");
		max = sc.nextDouble();
		System.out.print("Increment: ");
		i = sc.nextDouble();
		
		if (max < min)
		{
			System.out.println("ERROR: Invalid Max and Min");
			System.exit(0); //termina o programa
		} 
		
		System.out.println("Result:");
		System.out.println();
		
		r = min;
		while(r <= max)
		{
			double v, s;
			s = 4 * Math.PI * Math.pow(r, 2);
			v = 4/3 * Math.PI * Math.pow(r, 3);
			System.out.printf("Radius=%4.2f Surface=%7.2f Volume=%7.2f\n", r, s, v);
			
			r += i; //Equivalente a: r = r + i;
			vsum += v; // vsum = vsum + v;
			ssum += s;
		}
		
		System.out.printf("Sum: Surface=%8.2f Volume:%8.2f\n", ssum, vsum);
	}
}
