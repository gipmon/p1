/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e602_Temperaturas 
{
	static Scanner read = new Scanner (System.in);
	
	public static void main (String[] args) 
	{		
		String DiaFinal, Dia="Segunda";
		Temperatura Temp1 = new Temperatura();
		Temperatura Temp2 = new Temperatura();
		
		ReadTemp(Temp1, Dia);
		DiaFinal = Dia;
		
		for(int i=3 ; i<7 ; i++)
		{
			switch(i)
			{
				case 3: Dia = "Terça"; break;
				case 4: Dia = "Quarta"; break;
				case 5: Dia = "Quinta"; break;
				case 6: Dia = "Sexta"; break;
			} 
			ReadTemp(Temp2, Dia);
		
			if (Temp1.Amp < Temp2.Amp)
			{
				Temp1.tMin = Temp2.tMin;
				Temp1.tMax = Temp2.tMax;
				Temp1.Amp = Temp2.Amp;
				DiaFinal = Dia;
			}
		}

		System.out.printf("\nA amplitude térmica máxima foi de %.2f na %s Feira.",Temp1.Amp, DiaFinal);
		
	}
	
	public static void ReadTemp(Temperatura X, String Dia)
	{
		do
		{
		System.out.print("Temperatura minima de "+ Dia +":");
		X.tMin =read.nextDouble();	
		}while(X.tMin < -20 || X.tMin > 50);
		
		do
		{
		System.out.print("Temperatura maxima de "+ Dia +":");
		X.tMax =read.nextDouble();	
		}while(X.tMax < -20 || X.tMax > 50 || X.tMax < X.tMin);	
		X.Amp = X.tMax - X.tMin;
	}
}

class Temperatura
{
	double tMin;
	double tMax;
	double Amp;
	
}


