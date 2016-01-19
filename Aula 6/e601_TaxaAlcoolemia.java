/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e601_TaxaAlcoolemia
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		PersonData a;
		double TAS;
		
		a = LerPersonData();
		TAS = TAS(a);
		
		System.out.printf("\nA sua TAS é de: %.1f\n", TAS);
		
		if (TAS < 0.5)
			System.out.print("Pode conduzir.");
		else if (TAS >= 0.5 && TAS < 0.8)
			System.out.print("Infração grave.");
		else if (TAS >= 0.8 && TAS < 1.2)
			System.out.print("Infração muito grave.");
		else 
			System.out.print("Crime.");
	}
	
	public static double TAS (PersonData x)
	{
		
		double DensidadeAlcool = 0.8;
		double Coeficiente = 1.1;	
		double temp;
		
		temp = (DensidadeAlcool * x.ml * (x.teor/100))/(x.peso * Coeficiente);
		
		return temp;
	}
	
	public static PersonData LerPersonData()
	{
		PersonData temp;
		temp = new PersonData();
		do
		{
			System.out.print("Peso (Kg): ");
			temp.peso = read.nextDouble();
		}while(temp.peso <= 0);
		do
		{
			System.out.print("Quantidade de bebida ingerida (ml): ");
			temp.ml = read.nextDouble();
		}while(temp.ml <= 0);
		do
		{
			System.out.print("Teor alcoólico da bebida (%): ");
			temp.teor = read.nextDouble();
		}while(temp.teor < 0 || temp.teor > 100);
    
		return temp;
	}
  
}

class PersonData
{
	double peso;
	double ml;
	double teor;
}
