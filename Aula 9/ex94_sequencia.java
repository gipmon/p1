/*
 * Sequencia
 * Desenvolvimento e Comentários: Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 */
import java.util.Scanner;
import static java.lang.System.*;

public class ex94_sequencia{

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		
		int[] a = LerNumeros();
		ImpressaoResultados(a);
		
	}
	public static void ImpressaoResultados(int[] a){
		out.println("\nAnalise de uma sequencia numerica do tipo 5*K+2 \n");
		out.printf("Numero de elementos = %2d\n\n",a.length);
		
		int k;
		for(int i=0; i<a.length; i++){
			
			k=(a[i]-2)/5;
			out.printf("5*%d =%2d   ",k,a[i]);
			
			if(i%6==0 && i!=0)
				out.println();
		}
		
		out.println("\n");
		
		if(SequenciaContinua(a))
			out.println("A sequencia acima constitui uma sequencia contınua de numeros");
		else{
			out.println("A sequencia acima não constitui uma sequencia contınua de numeros");
			out.println("[Separacao maxima entre elementos sucessivos = "+SeparacaoMax(a)+"]");
		}
		
	}
	public static int SeparacaoMax(int[] a){
		int tmp[] = ArrayTemp(a);
		
		int max=0;
		
		for(int i=0; i<tmp.length-1; i++)
			if(tmp[i+1]-tmp[i]>max)
				max=tmp[i+1]-tmp[i];
			
		return max;
	}
	public static void BoobleSort(int[] a){
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
	public static boolean SequenciaContinua(int[] a){
		boolean continua = true;
		int tmp[] = ArrayTemp(a);
		
		for(int i=0; i<tmp.length-1; i++)
			if((tmp[i+1]-2)/5-(tmp[i]-2)/5!=1)
				continua=false;
				
		return continua;
		
	}
	public static int[] LerNumeros(){
		int[] tmp;
		tmp = new int[30];
		int i=-1;
		
		do{
			i++;
			
			do{
				out.print("Valor do elemento "+i+"? ");
				tmp[i]=sc.nextInt();
			}while((tmp[i]!=0 && (tmp[i]-2)%5!=0 ) || tmp[i]<0);
			
		}while(tmp[i]!=0 && i<29);
		
		if(i<29){
			
			int[] b = new int[i];
			
			for(int a=0; a<b.length; a++){
					b[a]=tmp[a];	
				}
			
			return b;
			
		}else
			return tmp;
		
	}
	public static int[] ArrayTemp(int[] a){
		int tmp[] = new int[a.length];
		
		for(int i=0; i<a.length; i++)
			tmp[i]=a[i];
			
		BoobleSort(tmp);
		return tmp;
	}

}
