/* Matrizes - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 */
import java.util.*;
import static java.lang.System.*;

public class ex102_matrizes{
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
			int[][] dim = LeituraDimensoes();
			
			int[][] a = LeituraMatrizes(dim[0]);
			int[][] b = LeituraMatrizes(dim[1]);
			out.println("\nMatriz resultante da multiplicação:");
			ImprimirMatriz(MultiplicacaoMatrizes(a,b));
	}
	public static int[][] LeituraDimensoes(){
			int[][] dim;
			dim = new int[2][2];
			
			/* m c0=linhas  c1=colunas
			 * 	|----------|----------| 
			 * 0|          |    	  |
			 * 	|----------|----------|
			 * 1|          |    	  |
			 * 	|----------|----------|
			 */
			out.println("*** Leitura das dimensões das matrizes ***\n");
			 
			do{
				for(int m=0; m<2; m++)
					for(int c=0; c<2; c++){
						if(c==0)
							out.printf("%dº Matriz, nº Linhas: ", m+1);
						else
							out.printf("%dº Matriz, nº Colunas:", m+1);
						dim[m][c]=sc.nextInt();	
					}
					
				if(dim[0][1]!=dim[1][0])
					out.println("\nRespeite as regras de multiplicação de matrizes!");
					
			}while(dim[0][1]!=dim[1][0]);
			
			return dim;
	}
	public static int[][] LeituraMatrizes(int[] a){
		int[][] matriz;
		matriz = new int[a[0]][a[1]];
		
		out.println("\n*** Leitura de Matriz ***");
		out.println("-sendo a[l][c], l=linha, c=coluna \n");
		
		for(int l=0; l<a[0]; l++)
				for(int c=0; c<a[1]; c++){
					out.printf("m[%d][%d] = ",l+1,c+1);
					matriz[l][c]=sc.nextInt();
				}
		
		out.println("\n*** Leitura Concluída ***");		
		return matriz;
	}
	public static int[][] MultiplicacaoMatrizes(int[][] a, int[][] b){
		int[][] matriz;
		matriz = new int[a.length][b[0].length];
		
		for(int l=0; l<a.length; l++)
			for(int c=0; c<b[0].length; c++)
				for(int i=0; i<a[0].length; i++)
					matriz[l][c]+=a[l][i]*b[i][c];	
				
		return matriz;
	}
	public static void ImprimirMatriz(int[][] a){
		for(int l=0; l<a.length; l++){
			for(int c=0; c<a[0].length; c++)
				out.printf(" %d  ",a[l][c]);
			out.println();
		}
	}
}
