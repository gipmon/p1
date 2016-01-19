/*
 * Programa de inversao de Arrays
 * Dev/Comentários © Rafael Ferreira
 */
import static java.lang.System.*;
import java.util.*;

public class ex81_invert_v1{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int a[];
		a = LerArray();
		a = Inversa(a);
		WriteArray(a);
	}
	public static int[] LerArray(){
		int i=0, temp;
		//Array temporário
		int tmp[];
		tmp = new int[10];
		do{
			out.printf("a[%d] :=",i);
			temp=sc.nextInt();
			if(temp>=0)
				tmp[i]=temp;
			i++;
		}while(i<10 && temp>=0);
		//Se for igual a 10 faz o return da array tmp, se for menor então criamos uma nova array a menor que depois ao fazermos o 
		//return vai ser assumido na variavel da main como estando apontar para a memória onde está guardada a nossa nova array
		if(i==10)
			return tmp;
		else{
			int b[];
			i--;// decremento pois no último while o i saiu com +1 valor do que o necessário
			b = new int[i];
			for(int c=0; c<i ; c++)
					b[c]=tmp[c];
			return b;
		}
	}
	public static void WriteArray(int a[]){
		out.println("------ARRAY------");
		for(int i=0; i<a.length; i++)
			out.printf("a[%d] := %d \n",i,a[i]);
	}
	public static int[] Inversa(int a[]){
		int inversa[];
		int b=a.length-1;
		inversa = new int[a.length];
		for(int i=0; i<a.length; i++){
			inversa[i]=a[b];
			b--;
		}
		return inversa;
	}
}

