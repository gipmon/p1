/*
 * Analise Sequencia Com ordenação e Pesquisa
 * Desenvolvimento e Comentários: Bruno Reis (Aula 8)
 * Revisão e Desenvolvimento: Rafael Ferreira (Aula 9)
 */
import java.util.*;
import static java.lang.System.*;
public class ex91_analisequencia_oddpesq{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		int opcao, n=0;
		int a[];
		boolean first=true;
		
		out.println("Análise de uma sequencia de numeros inteiros");
		out.println("--------------------------------------------");
		out.println("Insira uma sequência de números (max 50, terminar 0):");
		a=lersequencia();
				
		do
		{
				out.println("--------------------------------------------");
				out.println("  1 - Ler outra sequêcia");
				out.println("  2 - Escrever a sequência");
				out.println("  3 - Calcular o máximo da sequência");
				out.println("  4 - Calcular o minimo da sequência");
				out.println("  5 - Calcular a média da sequência");
				out.println("  6 - Detetar se é uma sequência só constituída por numeros pares");
				out.println("  7 - Ordenar a sequência por ordem crescente utilizando ordenação sequêncial");
				out.println("  8 - Ordenar a sequência por ordem decrescente usando ordenação por flutuação");
				out.println("  9 - Pesquisa de valor na sequência");
				out.println(" 10 - Terminar programa \n");
				out.print(" Opçao ->");
				opcao = sc.nextInt();
				out.println();
				//Execucao das funcoes
				LimparTerminal();
			
				   switch (opcao)
				   {
						case 1: a=lersequencia();
								break;
						case 2: escreversequencia(a);
								break;
						case 3: max(a);
								break;
						case 4: min(a);
								break;
						case 5: media(a);
								break;
						case 6: sequenciapar(a);
								break;
						case 7: OddSeq(a);
								break;
						case 8: OddFlu(a);
								break;
						case 9: Pesquisa(a);
								break;
						case 10: 
								out.println("Fim do programa!");
								break;
						default:
							out.println("É necessária a leitura da sequência primeiro! \n");
					}
			
		}while(opcao != 10);	
		
	}
	public static int[] lersequencia()
	{   
		int n=0;
		int a[];
		a = new int[50];
		
		for (int i=0; i < a.length; i++)
		{
		    out.printf("Insira o valor da posição a[%d]: ", i);
		    a[i]=sc.nextInt();
		    n++;
		    if(a[i]==0)
				break;
	    }
	    
	    if(n<50){
			int b[];
			b = new int[n-1];
			for (int i=0; i<n-1; i++)
				if(a[i]!=0)
					b[i]=a[i];
				
			return b;
		}else{
			return a;
		}
	}
    
    public static  void escreversequencia(int a[])
    {
		out.println("Sequência: ");
		for(int i=0; i < a.length; i++ )
			out.printf("a[%d] = %d\n", i, a[i]);
	}
   
    public static void max(int a[])
    {
		int m=0;
		for(int i=0; i < a.length; i++)
			if (a[i] > m)
				m = a[i];
		out.printf("O máximo é : %d\n", m);
	    
	}
   
    public static void min(int a[])
    {
		int m = a[0];
		
		for(int i=1; i < a.length; i++)
			if (a[i] < m && a[i] != 0)
				m = a[i];
		out.printf("O minimo é : %d\n", m);
	    
	}

    public static void media(int a[])
    {
		double media=0;
		
		for(int i=0; i<a.length;i++)
			media += a[i];
		
		media = media/a.length;
		out.printf("A media da sequência é %4.1f\n", media);
	}
    public static void sequenciapar(int a[])
    {
		boolean par=true;
		
		for(int i=0; i<a.length; i++)
			if((a[i] % 2) != 0)
				par = false;
		
		if(par == false)
			out.println("A sequência de números não e constituida so por números pares.");
		else
			out.println("A sequência de números é constituida só por números pares.");
	}
	public static void OddSeq(int a[]){
		int tmp;
		
		for(int i=0; i < a.length-1; i++)
			for(int j=i+1; j<a.length; j++)
				if(a[i] > a[j]){
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
		
		out.println("Sequência ordenada !");	
	}
	public static void OddFlu(int a[]){
		int tmp, j;
		boolean trocas;
		do{
			trocas = false; 
			for(int i=0 ; i<a.length-1; i++)
				if(a[i] < a[i+1]){
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					trocas = true;
				}
		}while(trocas); 
		out.println("Sequência ordenada !");
	}
	public static void Pesquisa(int a[]){
		out.print("Qual é o número que pretende pesquisar? ");
		int n = sc.nextInt();
		boolean nencontrado=true;
		for(int i=0; i<a.length; i++)
			if(a[i]==n){
				out.println("O número foi encontrado na posição: "+i);
				nencontrado=false;
				break;
			}
		if(nencontrado)
			out.println("Nada foi encontrado !");
	}
	public static void LimparTerminal()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
}



