/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e402_Calender
{
	static Scanner read = new Scanner(System.in);
		
	public static void main (String[] args)
	{
		int Ano, Mes;
		int Dias;
		boolean bissexto;
		String strMes;
		
		Ano = ReadInt();
		Mes = ReadInt(1, 12);
		
		bissexto = Bissexto(Ano);
		Dias = DiasDoMes(Mes, bissexto);
		strMes = StringMonth(Mes);
		
		System.out.printf("O mês de %s do ano %d tem %d dias.", strMes, Ano, Dias);
	}

	public static int ReadInt ()
	{
		int x;
		System.out.print("Introduza um ano: ");
		x = read.nextInt();
		return x;
	}
	
	public static int ReadInt (int LimitInf, int LimitSup)
	{
		int x;
		do
		{
		System.out.print("Introduza o mês: ");
		x = read.nextInt();		
	    }while(x < LimitInf || x > LimitSup);
		return x;
	}


	public static String StringMonth(int Month)
	{
		String strMonth;
		switch (Month)
		{
			case 1:
			strMonth = "Janeiro";
			break;
			case 2:
			strMonth = "Fevereiro";
			break;
			case 3:
			strMonth = "Março";
			break;
			case 4:
			strMonth = "Abril";
			break;
			case 5:
			strMonth = "Maio";
			break;
			case 6:
			strMonth = "Junho";
			break;
			case 7:
			strMonth = "Julho";
			break;
			case 8:
			strMonth = "Agosto";
			break;
			case 9:
			strMonth = "Setembro";
			break;
			case 10:
			strMonth = "Outubro";
			break;
			case 11:
			strMonth = "Novembro";
			break;
			case 12:
			strMonth = "Dezembro";
			break;
			default:
			strMonth = "ERROR";
			break;
		}
		return strMonth;
	}
	
	public static boolean Bissexto (int Year)
	{
		boolean bissexto=false;
		if (Year % 4 == 0)
		bissexto = true;
		if (Year >= 1800 && Year % 100 == 0 && Year % 400 != 0)
		bissexto = false;
		
		return bissexto;
	}

	public static int DiasDoMes (int Month, boolean bissexto)
	{
		int Days;
		if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12)
		Days = 31;
		else if (Month == 4 || Month == 6 || Month == 9 || Month == 11)
		Days = 30;
		else
		{
			if (bissexto == true)
			Days = 29;
			else 
			Days = 28;
		}
		return Days;
	}
	
}
