/*
 * Desenvolvido por Diogo Corte
 */
 import java.util.*;

public class e606_Complexos 
{
	static Scanner read = new Scanner(System.in);
	
	public static void main (String[] args) 
	{
		Complexo comp_1 = new Complexo();
		Complexo comp_2 = new Complexo();
		Complexo Calculo = new Complexo();
		String s = new String();
		char c;
		do
		{
			System.out.print("Operação: ");
			do
			{
				s = read.nextLine();
				c = s.charAt(0);
			}while(s.length() != 1);
			if (c=='+' || c=='-' || c=='*' || c=='/')
			{
				LeituraComplexo(comp_1);
				LeituraComplexo(comp_2);
				switch(c)
				{
					case '+': Calculo = AdicaoComplexos(comp_1, comp_2); break;
					case '-': Calculo = SubtracaoComplexos(comp_1, comp_2); break;
					case '*': Calculo = MultiplicacaoComplexos(comp_1, comp_2); break;
					case '/': Calculo = DivisaoComplexos(comp_1, comp_2); break;
					default: break;
				}
				EscreverComplexo(comp_1);
				System.out.print(c);
				EscreverComplexo(comp_2);
				System.out.print("=");
				EscreverComplexo(Calculo);
				System.out.println();
				read.nextLine();
			}
			else if (c!='=')
			System.out.println("Operação não permitida!");
		}while(c!='=');
		System.out.print("O programa vai terminar...");
		
	}
	
	public static Complexo DivisaoComplexos (Complexo X, Complexo Y)
	{
		Complexo Z = new Complexo();
		Z.r = ((X.r * Y.r) + (X.i * Y.i))/(Math.pow(Y.r,2)+Math.pow(Y.i,2));
		Z.i = ((X.i * Y.r) - (X.r * Y.i))/(Math.pow(Y.r,2)+Math.pow(Y.i,2));;
		return Z;
	}
	
	public static Complexo MultiplicacaoComplexos (Complexo X, Complexo Y)
	{
		Complexo Z = new Complexo();
		Z.r = (X.r * Y.r) - (X.i * Y.i);
		Z.i = (X.i * Y.r) + (X.r * Y.i);
		return Z;
	}
	
	public static Complexo SubtracaoComplexos (Complexo X, Complexo Y)
	{
		Complexo Z = new Complexo();
		Z.r = X.r - Y.r;
		Z.i = X.i - Y.i;
		return Z;
	}
	
	public static Complexo AdicaoComplexos (Complexo X, Complexo Y)
	{
		Complexo Z = new Complexo();
		Z.r = X.r + Y.r;
		Z.i = X.i + Y.i;
		return Z;
	}
	
	public static void EscreverComplexo(Complexo X)
	{
		if (X.i < 0) System.out.printf(" %4.1f-i%4.1f ", X.r, Math.abs(X.i));
		else if (X.i > 0) System.out.printf(" %4.1f+i%4.1f ", X.r, X.i);
		else System.out.printf(" %4.1f ", X.r);
	}

	public static void LeituraComplexo (Complexo X)
	{
		System.out.println("Introduza um número complexo: ");
		System.out.print("Parte real: ");
		X.r=read.nextDouble();
		System.out.print("Parte imag: ");
		X.i=read.nextDouble();
	}
}

class Complexo
{
	double r;
	double i;
}



