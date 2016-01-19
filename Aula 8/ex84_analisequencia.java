/*
 * Analise Sequencia
 * Desenvolvimento e Comentários: Bruno Reis
 * Revisão: Rafael Ferreira
 */
import java.util.*;
import static java.lang.System.*;
public class ex84_analisequencia{
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String args[]) {
		
		int opcao, n=0;
		int a[] = new int[50];
		boolean first=false;
		
		do
		{
			if(!first)
				out.println("Análise de uma sequencia de numeros inteiros");
				
			out.println();
			out.println("  1 - Ler a sequêcia");
			out.println("  2 - Escrever a sequência");
			out.println("  3 - Calcular o máximo da sequência");
			out.println("  4 - Calcular o minimo da sequência");
			out.println("  5 - Calcular a média da sequência");
			out.println("  6 - Detetar se é uma sequência só constituída por numeros pares");
			out.println(" 10 - Terminar programa \n");
			out.print(" Opçao ->");
			opcao = sc.nextInt();
			out.println();
		if(opcao==1 && first==false)
			first=true;
			LimparTerminal();
			if(first || opcao==1 || opcao==10){
			   switch (opcao)
			   {
					case 1: n = lersequencia(a);
							break;
					case 2: escreversequencia(a, n);
							break;
					case 3: max(a, n);
							break;
					case 4: min(a, n);
							break;
					case 5: media(a, n);
							break;
					case 6: sequenciapar(a, n);
							break;
					case 10:
							out.println("Fim do programa!");
							break;
					default:
						out.println("É necessária a leitura da sequência primeiro! \n");
				}
			}else{
				out.println("É necessária a leitura da sequência primeiro! \n");
			}
		}while(opcao != 10);	
		
	}
	public static int lersequencia(int a[])
	{   
		int n=-1;
		for (int i=0; i < a.length; i++)
		{
		    out.printf("Insira o valor da posição a[%d]: ", i);
		    a[i]=sc.nextInt();
		    n++;
		    if(a[i]==0)
				break;
	    }
		return n;
	}
    
    public static  void escreversequencia(int a[],int n)
    {
		out.println("Sequência: ");
		for(int i=0; i < n; i++ )
			out.printf("a[%d] = %d\n", i, a[i]);
	}
   
    public static void max(int a[], int n)
    {
		int m=0;
		for(int i=0; i < n; i++)
			if (a[i] > m)
				m = a[i];
		out.printf("O máximo é : %d\n", m);
	    
	}
   
    public static void min(int a[], int n)
    {
		int m = a[0];
		
		for(int i=1; i < n; i++)
			if (a[i] < m && a[i] != 0)
				m = a[i];
		out.printf("O minimo é : %d\n", m);
	    
	}

    public static void media(int a[], int n)
    {
		double media=0;
		
		for(int i=0; i<n;i++)
			media += a[i];
		
		media = media/n;
		out.printf("A media da sequência é %4.1f\n", media);
	}
    public static void sequenciapar(int a[], int n)
    {
		boolean par=true;
		
		for(int i=0; i<n; i++)
			if((a[i] % 2) != 0)
				par = false;
		
		if(par == false)
			out.println("A sequência de números não e constituida so por números pares.");
		else
			out.println("A sequência de números é constituida só por números pares.");
	}
	public static void LimparTerminal()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
}



