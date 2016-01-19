/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e301_Inverter
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		int x, y = 0;
		int temp, temp_1;

		do
		{
			System.out.print("Introduza um numero: ");
			x = read.nextInt();
		} while(x <= 0);
		
		temp = x;

		do
		{
			temp_1 = temp % 10;
			temp = temp / 10;
			y = y * 10 + temp_1;
		} 
		while(temp != 0);

		System.out.printf("%d -> %d\n", x, y);
	}
}
