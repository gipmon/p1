/*
 * Analisador de ph
 * Desenvolvimento e Comentários: Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 */
import java.util.*;
import static java.lang.System.*;
 
public class ex92_ph{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		int menu;
		//Pedido inicial
		out.println("Analisador de pH");
		out.println("--------------------------");
		out.println("1 - Inserir valores de pH");
		out.println("--------------------------");
		double[] ph = LerValores();
		
		do{
			
			menu = menu(); // inicializamos a variavel menu com uma função que retorna o valor int e depois
			//iremos fazer o Limpar do Terminal seguido do switch para chamar as funções de menu
			LimparTerminal();
			
			switch (menu)
			{
				case 1: ph = LerValores();
					break;
				case 2: EscreverValores(ph);
					break;
				case 3: ValorMedia(ph);
					break;
				case 4: BasicasAcidas(ph);
					break;
				case 5: SuperiorAMedia(ph);
					break;
				case 6: OrdFlut(ph);
					break;
				case 7: out.println("Adeus !");
					break;
			}
		}while(menu!=7);
		
			
			
			
	}
	public static int menu(){
		
		int tmp;
		
		out.println("\nAnalisador de pH");
		out.println(" 1 - Ler outros valores de pH.");
		out.println(" 2 - Escrever valores de pH.");
		out.println(" 3 - Calcular o pH médio das amostras.");
		out.println(" 4 - Calcular o número de amostras ácidas e básicas.");
		out.println(" 5 - Calcular o número de amostras de pH superior à média.");
		out.println(" 6 - Ordenar (de modo crescente) a lista de valores de pH.");
		out.println(" 7 - Terminar o programa.");
		
		
		do{
			out.print("Opção ->");
			tmp= sc.nextInt();
			
		}while(tmp<1 || tmp>7);
		out.println();
		return tmp;
	}
	public static double[] LerValores(){
		double[] tmp;
		int i=-1;
		tmp = new double[50];
		
		out.println("* Recolha de amostras *");
			
		do{
		
			i++;
			out.printf("Valor pH[%d]: ", i);
			tmp[i]=sc.nextInt();
			
		}while(tmp[i]>=0 && tmp[i]<=14 && i<50);
		
		if(i<50){
			double[] a;
			a = new double[i];
			
			for(int b=0; b<i; b++)
				a[b]=tmp[b];
			return a;
		}else
			return tmp;
			
	}
	public static void EscreverValores(double[] a){
		out.println("*Valores de pH*");
		for(int i=0; i<a.length; i++)
			out.printf("a[%d] = %.2f \n", i, a[i]);
	}
	public static void ValorMedia(double[] a){
		double media=0;
		for(int i=0; i<a.length; i++)
			media+=a[i];
		out.printf("Média: %.2f \n",media/a.length);
	}
	public static void BasicasAcidas(double[] c){
		int a=0, b=0 , n=0;
		
			for(int i=0; i<c.length; i++){
				if(c[i]<7)
					a++;
				else if(c[i]>7)
					b++;
				else 
					n++;
			}
			out.printf("\n Amostras básicas: %d \n Amostras ácidas: %d \n Amostras neutras: %d\n",b,a,n);
	}
	public static void 	SuperiorAMedia(double[] c){
		double media=0;
		int i, s=0;
		for(i=0 ; i<c.length; i++)
			media+=c[i];
			media/=c.length;
		for(i=0; i<c.length; i++)
			if(c[i]>media){
				s++;
			}
		if(s>0)
			out.printf("Existem %2d valores superiores à média.\n", s);	
		else
			out.println("Não existem valores superiores à média.");
	}
	public static void OrdFlut(double[] c){
		boolean trocas;
		double tmp;
		
		do{
			trocas=false;
			for(int i=0; i<c.length-1; i++){
				if(c[i]>c[i+1]){
					tmp=c[i+1];
					c[i+1]=c[i];
					c[i]=tmp;
					trocas = true;
				}
			}
		}while(trocas);
		out.println("Sequência ordenada !");
		
	}
	public static void LimparTerminal()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

