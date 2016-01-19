/*
 * Totoloto
 * Desenvolvimento e Comentários: Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 */
import java.util.*;
import static java.lang.System.*;

public class ex93_totoloto{

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int[] chave = chave();
		BobleSort(chave);
		EscritaAposta(chave);
	}
	public static int[] chave(){
		int[] tmp;
		tmp = new int[6];
		for(int i=0; i<6; i++){
			out.print("Elemento "+i+" da chave = ");
			tmp[i]=sc.nextInt();
		}
		return tmp;
	}
	public static void BobleSort(int[] a){
		boolean trocas;
		int tmp;
		do{
			trocas=false;
			
			for(int i=0; i<a.length-1; i++)
				if(a[i]>a[i+1]){
					tmp=a[i+1];
					a[i+1]=a[i];
					a[i]=tmp;
					trocas=true;
				}
			
		}while(trocas);
	}
	public static void EscritaAposta(int[] a){
		out.println("\n   Aposta de totoloto");
		boolean replace; // esta variavel serve para sabermos qual o número que devemos susbstituir por X
		
		for(int i=1; i<=49; i++){
			replace=false;
			
			for(int w=0; w<a.length; w++){ // percurremos a array de int a toda para sabermos quais os numeros que 
				//devemos susbstituir pela chave
				if(a[w]==i)
					replace=true;
			}
			//aqui vamos susbstituir
			if(replace)
				out.print(" X");
			else
				out.printf("%2d",i);
			//espaços entre os números
			out.print("  ");
			//fazer os paragrafos
			if(i%7==0)
				out.println();
		}
	}
	
}
