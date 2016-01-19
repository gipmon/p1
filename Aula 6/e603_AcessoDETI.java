/*
 * Desenvolvido por Diogo Corte
 */
import java.util.*;

public class e603_AcessoDETI 
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args) 
	{
		Aluno aluno = new Aluno();
		System.out.print("Nº Mecanográfico: ");
		aluno.mec = read.nextInt();
		System.out.println("Hora de Entrada ");
		lerHora(aluno.entrada);
		System.out.println("Hora de Saida ");
		lerHora(aluno.saida);
		
		System.out.print("\n\n");
		System.out.printf("O Aluno %d entrou no DETI.\n", aluno.mec);
		System.out.print("Hora de Entrada: "); PrintHora(aluno.entrada);
		System.out.print("Hora de Saida: "); PrintHora(aluno.saida);
	}
	
	public static void PrintHora (Hora x)
	{
		if (x.hora<10) System.out.printf("0%d:",x.hora);
		else System.out.printf("%d:",x.hora);
		if (x.min<10) System.out.printf("0%d:",x.min);
		else System.out.printf("%d:",x.min);
		if (x.seg<10) System.out.printf("0%d",x.seg);
		else System.out.printf("%d\n",x.seg);
	}   
	
	public static void lerHora (Hora x)
	{
		do
		{
		System.out.print("Hora: ");
		x.hora = read.nextInt();
		}while(x.hora<0 || x.hora>23);
		do
		{
		System.out.print("Min: ");
		x.min = read.nextInt();
		}while(x.min<0 || x.min>59);
		do
		{
		System.out.print("Seg: ");
		x.seg = read.nextInt();
		}while(x.seg<0 || x.seg>59);
	}
}

class Hora
{
	int hora;
	int min;
	int seg;
}

class Aluno
{
	int mec;
	Hora entrada = new Hora();
	Hora saida = new Hora();
}

