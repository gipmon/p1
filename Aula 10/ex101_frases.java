/* Análise de frases - Rafael Ferreira
 * Dúvidas: rafael.ferreira@ua.pt
 * wwww.rafaelferreira.pt/recursos
 */
import java.util.*;
import static java.lang.System.*;

public class ex101_frases{
	public static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) {
		String[] frases = LerFrases();
		AnaliseFrase a = AnaliseFrases(frases);
		ImprimirResultado(a);
	}
	public static String[] LerFrases(){
		
		String[] frase;
		frase = new String[10];
		int i=-1;
		
			do{
				i++;
				out.print("Frase a analisar? ");
				frase[i]=sc.nextLine();
			}while(!frase[i].equals("fim") && i<9);
			
			if(i<9){
				String[] b;
				b = new String[i];
				
				for(int a=0; a<i; a++){
					if(!frase[a].equals("fim"))
						b[a] = frase[a];
				}
				return b;
			}else
				return frase;
				
		}
		public static AnaliseFrase AnaliseFrases(String[] a){
			AnaliseFrase b = new AnaliseFrase();
		
			for(int i = 0; i<a.length; i++)
			{
					for(int z=0; z<a[i].length(); z++)
					{
						if(Character.isDigit(a[i].charAt(z)))
							b.numericos++;
						else if(Character.isUpperCase(a[i].charAt(z)))
							b.maiusculas++;
						else if(Character.isLetter(a[i].charAt(z)))
							b.minusculas++;
						
						if(a[i].charAt(z)=='a' || a[i].charAt(z)=='e' || a[i].charAt(z)=='i' || a[i].charAt(z)=='o' || a[i].charAt(z)=='u' || a[i].charAt(z)=='A' || a[i].charAt(z)=='E' || a[i].charAt(z)=='I' || a[i].charAt(z)=='O' || a[i].charAt(z)=='U')
							b.vogais++;
						else if(Character.isLetter(a[i].charAt(z)))
							b.consoantes++;
					}
			}
			CountWordsAdvanced(a, b);
			//CountWordsSimplex(a,b);
			return b;
		}
		//nao funciona a funcao split
		public static void CountWordsSimplex(String[] a, AnaliseFrase b){
			
			String palavras[] = new String[10];// palavras;
			
			for(int i=0; i<a.length; i++){
				palavras = a[i].split(".[^a-zA-Z]+");
				b.palavras+= palavras.length;
			}
			
			
			for(int i=0; i<palavras.length; i++)
				out.printf("Palavras = %d %s\n",palavras.length,palavras[i]);
			
		}
		public static void CountWordsAdvanced(String[] a, AnaliseFrase b){
			//Contar número de palavras (Advanced)
				for(int i = 0; i<a.length; i++)
					for(int w = 0; w<a[i].length(); w++)
						if(Character.isLetterOrDigit(a[i].charAt(w))) // contando com os números por exemplo 89n é uma palavra
							for(int z=w; z<a[i].length(); z++) 
								if(!Character.isLetterOrDigit(a[i].charAt(z)) || z==a[i].length()-1){
									w=z;
									b.palavras++;
									break;
								}
		}
		
		public static void ImprimirResultado(AnaliseFrase a){
			out.println("\nAnálise estatística\n");
			out.println("Número total de vogais -> "+a.vogais);
			out.println("Número total de consoantes -> "+a.consoantes);
			out.println("Número total de caracteres minúsculos -> "+a.minusculas);
			out.println("Número total de caracteres maiúsculos -> "+a.maiusculas);
			out.println("Número total de caracteres numéricos -> "+a.numericos);
			out.println("Número total de palavras -> "+a.palavras);
		}
	}
class AnaliseFrase{
		int vogais, consoantes, minusculas, maiusculas, numericos, palavras;
}

