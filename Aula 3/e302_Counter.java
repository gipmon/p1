/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e302_Counter
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		int Pos = 0, Neg = 0;
		int BigPos = 0, SmallNeg = 0;
		int temp;
		
		System.out.println("### Number Counter ###");
		System.out.println("Enter numbers(type 0 to exit). ");
	
		do
		{
			temp = read.nextInt();

			if (temp >0) Pos++;
			if (temp>=100 && temp<=1000) BigPos++;
			if (temp<0) Neg++;
			if (temp<-100 && temp>-1000) SmallNeg++;
		}
		while(temp != 0);

		System.out.printf("Positive number count: %d \n", Pos);
		System.out.printf("Negative number count: %d \n", Neg);
		System.out.printf("[100 ... 1000] count: %d \n", BigPos);
		System.out.printf("[-100 ... -1000] count: %d \n", SmallNeg);
	}	
}
