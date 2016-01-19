/*
 * Desenvolvido por Diogo Corte
 */
import java.util.Scanner;

public class e308_Calender
{
	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);
		
		int Year, Month, WeekDay;
		
		int MaxDays;
		boolean bissexto = false;
		String strMonth, strDay;
		
		System.out.print("Introduza um ano: ");
		Year = read.nextInt();
		
		if (Year%4 == 0) bissexto = true;
		if (Year >= 1800 && Year%100 == 0 && Year%400 != 0) bissexto = false;
		
		do
		{
		System.out.print("Introduza o mês: ");
		Month = read.nextInt();		
	    }
	    while(Month < 0 || Month > 12);
	    
	    switch (Month)
		{
			case 1: strMonth = "Janeiro"; break;
			case 2:	strMonth = "Fevereiro";	break;
			case 3:	strMonth = "Março"; break;
			case 4:	strMonth = "Abril"; break;
			case 5:	strMonth = "Maio"; break;
			case 6:	strMonth = "Junho";	break;
			case 7:	strMonth = "Julho";	break;
			case 8:	strMonth = "Agosto"; break;
			case 9:	strMonth = "Setembro"; break;
			case 10: strMonth = "Outubro"; break;
			case 11: strMonth = "Novembro"; break;
			case 12: strMonth = "Dezembro";	break;
			default: strMonth = "ERROR"; break;
		}
	    
	    for (int WeekDayInt=1 ; WeekDayInt<=7 ; WeekDayInt++)
			{
				switch (WeekDayInt)
				{
					case 1: strDay = "Domingo"; break;
					case 2: strDay = "Segunda"; break;
					case 3: strDay = "Terça"; break;
					case 4: strDay = "Quarta"; break;
					case 5: strDay = "Quinta"; break;
					case 6: strDay = "Sexta"; break;
					case 7: strDay = "Sábado"; break;
					default: strDay = "ERROR"; break;
				}
				
				System.out.printf("%d - %s \n", WeekDayInt, strDay);
			}
		
		do
		{
		System.out.print("Introduza o dia da semana em que começa o mês (0<D<8): ");
		WeekDay = read.nextInt();
		}
		while( WeekDay>7 || WeekDay<1 );
	    
		if (Month == 1 || Month == 3 || Month == 5 || Month == 7 || Month == 8 || Month == 10 || Month == 12) MaxDays = 31;
		else if (Month == 4 || Month == 6 || Month == 9 || Month == 11) MaxDays = 30;
		else
		{
			if (bissexto == true)
			MaxDays = 29;
			else 
			MaxDays = 28;
		}
		
		System.out.println("\n      ----------------------");
		System.out.printf("      |   %9s %4d   |\n" , strMonth, Year);
		System.out.println("      ----------------------");
		System.out.println("      |Su Mo Tu We Th Fr Sa|");
		System.out.print("      |");
		
		for(int n=1 ; n<=MaxDays ; n++)
		{
			if (WeekDay == 8) WeekDay = 1;
			
			if (n==1)
			{
				for (int i = 1; i < WeekDay; i++) System.out.print("   ");	
			}
			
			if (WeekDay == 1 && n!=1) System.out.printf("      |%2d ", n);
			
			else if (WeekDay == 7) System.out.printf("%2d|\n", n);
			
			else System.out.printf("%2d ", n);
			
			if(n == MaxDays && WeekDay != 7) 
			{
				WeekDay = -1*(WeekDay - 7);
				for (int i = 1; i<WeekDay; i++) System.out.print("   ");	
				System.out.print("  |\n");
			}
			
			WeekDay++;
		}
		System.out.println("      ----------------------");
	
	}
}
