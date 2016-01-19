/*
 * Programa de calculo de média, desvio padrão;
 * Desenvolvimento: Bruno Reis
 * Revisão e Comentários: Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;

public class ex82_media{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
			int n;
			double media,sdp;
			out.print("Quantos números? ");
			n=sc.nextInt();
			//Declarar Array
			int a[];
			a=InsertArray(n); //Preenche-se a array a com a função insert array que por sua vez vai fazer o pedido do array com n 
			//posições e vai devolver (return) que depois vai ser assumido na variável a
			//Media
			media=Media(a);
			//Somatorio do Desvio Padrao
			sdp=DesvioPadrao(a, media);
			ImpressaoValores(a, media, sdp);
	}
	public static int[] InsertArray(int n){
		int tmp[];
		tmp = new int[n];
		for(int i=0; i<n; i++){
			out.printf("Inserir a[%d]: ",i);
			tmp[i]=sc.nextInt();
		} 
		return tmp;
	}
	public static double DesvioPadrao(int tmp[], double media){
		double valor=0, max=0;
		for(int i=0; i<tmp.length; i++){
			valor=Math.abs(tmp[i]-media); // o devio padrão é calculado pela math.sqrt(math.pow(x-media)) no entanto é = ao módulo;
			if(valor>=max)
				max=valor;
		}
		return max;
	}
	public static double Media(int tmp[]){
		int soma=0;
		
		for(int i=0; i<tmp.length; i++)
			soma+=tmp[i];
		
		return soma/tmp.length;
	}
	public static void ImpressaoValores(int tmp[], double d, double sdp){
		
		out.println(""); 
		out.printf("Média: %.2f \n", d);
		out.println("Valores superiores à média:"); 
		for(int i=0; i<tmp.length; i++){
			if(d<tmp[i])
				out.printf("a[%d]: %d \n", i,tmp[i]);
		}
		
		out.printf("Desvio Padrão: %.2f", sdp);
		
	}
}
