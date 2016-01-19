/*
 * Desenvolvido por Diogo Corte
 */
import java.util.*;

public class e604_DistanciaPontos 
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args) 
	{
		double Dist, DistSum=0;
		int counter; 
		Ponto2D MaisDistante = new Ponto2D();
		Ponto2D ponto = new Ponto2D();
		Ponto2D origem = new Ponto2D();
		origem.x = 0;
		origem.y = 0;
		
		LerPonto(MaisDistante);
		counter = 1;
		Dist = DistanciaPaP(MaisDistante, origem);
		DistSum += Dist;
		do
		{
			LerPonto(ponto);
			if(ponto.x!=0 || ponto.y!=0) 
			{
				counter++;
				Dist = DistanciaPaP(ponto, origem);
				DistSum += Dist;
				if(DistanciaPaP(ponto, origem) > DistanciaPaP(MaisDistante, origem))
				{
					MaisDistante.x = ponto.x;
					MaisDistante.y = ponto.y;
				}
			}
		}while(ponto.x!=0 || ponto.y!=0);
		
		System.out.printf("A soma das distâncias dos %d pontos à origem é %.1f \n",counter, DistSum);
		System.out.print("O ponto mais afastado da origem foi: ");
		EscreverPonto(MaisDistante);
	}
	
	
	public static double DistanciaPaP (Ponto2D ponto_1, Ponto2D ponto_2)
	{
		double Dist = Math.sqrt(Math.pow(ponto_2.x - ponto_1.x,2) + Math.pow(ponto_2.y - ponto_1.y, 2));
		return Dist;
	}
	
	public static void EscreverPonto (Ponto2D ponto)
	{
		System.out.printf("(%3.1f, %3.1f)", ponto.x, ponto.y);
	}
	
	public static void LerPonto (Ponto2D ponto)
	{
		System.out.println("Introduza um ponto:");
		System.out.print("Coordenada x: ");
		ponto.x= read.nextDouble();
		System.out.print("Coordenada y: ");
		ponto.y= read.nextDouble();
	}
	
	
}

class Ponto2D
{
	double x;
	double y;
}

