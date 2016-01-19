import java.util.Scanner;

public class ValorAbsoluto
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double x, m;
		
		//Documentação sobre a class Double: http://docs.oracle.com/javase/1.4.2/docs/api/java/lang/Double.html
		m = Double.MIN_VALUE; //Minimo valor positivo que uma variável double pode armazenar: 2^(-1074) ---> 0.000...0049 
		
		System.out.print("X? ");
		x=sc.nextDouble();
		while( x<=100 ) {
			if(Math.abs(x) > Math.abs(m))
			{
				m = x;
				System.out.println("Novo máximo encontrado");
			}
			System.out.print("X? ");
			
			x = sc.nextDouble();
		}
		System.out.printf("Máximo (em valor absoluto) = %.2f", m); //Resposta Alternativa: %f (tambem considerada correta)		
	}	
}
