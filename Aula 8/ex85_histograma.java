/*
 * Caracteres -> ASCII
 * Desenvolvimento e Comentários: Bruno Reis
 * Revisão: Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;
import java.io.*;

public class ex85_histograma{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		int a[]= lernotas();
		
		histograma(a);
		
	}
	
	public static int[] lernotas()
	{
		int a;
		//notas
		out.print("Notas a inserir: ");
		a = sc.nextInt();
		int[] tmp;
		tmp = new int[a];
		for(int i=0; i<a; i++)
		{ 
			do{
				out.printf("Nota (%d): ", i+1);
				tmp[i]= sc.nextInt();
		   }while(tmp[i]<0 || tmp[i]>20);
	    }
	    return tmp;
	}
	
	public static void histograma(int a[])
	{   
		
		out.println("\nHistograma de notas");
	    out.println("----------------------------------------");
	    //Contagem
	    // {70,40,30,80,50,40,30,20,1,4,10,12,13,34,23,55,33,44,55,60}; Se precisares de experimentar
	    int[] hist;
	    hist = new int[21];
	    int n=0, max=0;
	    double tmp;
	   
	    for( ; n<=20; n++){
			for(int i=0; i<a.length;i++)
			    if (a[i] == n)
					hist[n]+=1;
			if(hist[n]>max)
					max=hist[n];
		}
		//Proporção
		if(max>50){
			//proporcao
			double prop;
			prop=50.0/max;
			for(n=0; n<=20; n++){
				tmp=hist[n]*prop;
				hist[n]=(int)tmp;
			}
		}
		//construção do histograma
		for(n=0; n<=20; n++){
			
				out.printf("%2d [%2d] | ",n,hist[n]);
					for(int w=0; w<hist[n]; w++)
						out.print("*");
				out.println();
			
		}
		
	}

}

